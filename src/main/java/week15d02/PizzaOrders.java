package week15d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class PizzaOrders {
    private static final String DATE_FORMAT = "yyyy.MM.dd";
    private static final String TIME_FORMAT = "H:mm";

    Map<LocalDate, List<Couriers>> pizzaOrders = new HashMap<>();


    public PizzaOrders() {
        loadOrdersFromResource();
    }

    private void loadOrdersFromResource() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(PizzaOrders.class.getResourceAsStream("orders.txt")))) {
            String line = reader.readLine();
            while (line != null) {
                Optional<LocalDate> orderDateTime = getLocalDateFromString(line);
                if (orderDateTime.isPresent()) {
                    line = reader.readLine();
                    while (line != null && getLocalDateFromString(line).isEmpty()) {
                        Optional<String> courierName = getCourierName(line);
                        line = reader.readLine();
                        Optional<Order> order = getOrderFromString(line);
                        Couriers courier = new Couriers(courierName.orElseThrow(() -> {
                            throw new IllegalStateException("File format error");
                        }));
                        if (!pizzaOrders.containsKey(orderDateTime.get())) {
                            pizzaOrders.put(orderDateTime.get(), new ArrayList<>());
                        }
                        if (!pizzaOrders.get(orderDateTime.get()).contains(courier)) {
                            pizzaOrders.get(orderDateTime.get()).add(courier);
                        }
                        pizzaOrders.get(orderDateTime.get()).get(pizzaOrders.get(orderDateTime.get()).indexOf(courier)).addOrder(order.orElseThrow(() -> {
                            throw new IllegalStateException("File format error");
                        }));
                        line = reader.readLine();
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("File read error", e);
        }
    }



    private Optional<LocalDate> getLocalDateFromString(String str) {
        try {
            return Optional.of(LocalDate.parse(str, DateTimeFormatter.ofPattern(DATE_FORMAT)));
        } catch (DateTimeParseException ex) {
            return Optional.empty();
        }
    }

    private Optional<String> getCourierName(String str) {
        if (str.startsWith("FUT_")) {
            return Optional.of(str);
        }
        return Optional.empty();
    }


    private Optional<Order> getOrderFromString(String str) {
        try {
            String[] splittedStr = str.split(" ");
            if (splittedStr.length > 3) {
                return Optional.of(new Order(String.join(" ", splittedStr[0], splittedStr[1], splittedStr[2]), LocalTime.parse(splittedStr[3], DateTimeFormatter.ofPattern(TIME_FORMAT))));
            }
        } catch (DateTimeParseException ex) {
            return Optional.empty();
        }
        return Optional.empty();
    }

    public LocalDate getDateOfMinimumNumberOfOrders() {
        LocalDate retVal = LocalDate.MIN;
        int orders = Integer.MAX_VALUE;
        for (Map.Entry<LocalDate, List<Couriers>> item : pizzaOrders.entrySet()) {
            int ordersTmp = item.getValue().stream().mapToInt(o -> o.getOrders().size()).sum();
            if (orders > ordersTmp) {
                retVal = item.getKey();
                orders = ordersTmp;
            }
        }
        return retVal;
    }

    public Optional<Order> getOrderFromTime(LocalDateTime dateTime) {
        return pizzaOrders.entrySet().stream()
                .filter(o -> o.getKey().equals(dateTime.toLocalDate()))
                .flatMap(o -> o.getValue().stream()
                        .flatMap(oo -> oo.getOrders().stream()))
                .filter(o -> o.getTime().equals(dateTime.toLocalTime()))
                //.peek(System.out::println)
                .findFirst();
    }

    public Map<String, Integer> getOrdersStats() {
        Map<String, Integer> courierOrders = new HashMap<>();
        for (List<Couriers> items : pizzaOrders.values()) {
            for (Couriers item : items) {
                if (!courierOrders.containsKey(item.getName())) {
                    courierOrders.put(item.getName(), 0);
                }
                Integer tmp = courierOrders.get(item.getName());
                courierOrders.put(item.getName(), tmp + item.getOrders().size());
            }
        }
        return courierOrders;
    }

    public String getMostOrderedAddress() {
        List<Order> orders = pizzaOrders.entrySet().stream()
                .flatMap(o -> o.getValue().stream()
                        .flatMap(oo -> oo.getOrders().stream())).collect(Collectors.toList());

        Map<String, Integer> ordersByAddresses = new HashMap<>();
        for (Order item : orders) {
            ordersByAddresses.merge(item.getAddress(), 1, Integer::sum);
        }

        int max = Integer.MIN_VALUE;
        String retVal = "";
        for (Map.Entry<String, Integer> item : ordersByAddresses.entrySet())
            if (max < item.getValue()) {
                max = item.getValue();
                retVal = item.getKey();
            }
        return retVal;
    }


    public static void main(String[] args) {
        PizzaOrders orders = new PizzaOrders();
        System.out.println(orders.getDateOfMinimumNumberOfOrders());
        System.out.println(orders.getOrderFromTime(LocalDateTime.of(2020, 12, 2, 12, 40)));
        System.out.println(orders.getOrdersStats());
        System.out.println(orders.getMostOrderedAddress());
    }

}
