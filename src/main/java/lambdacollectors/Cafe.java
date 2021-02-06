package lambdacollectors;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Cafe {
    List<CoffeeOrder> orders;

    public Cafe(List<CoffeeOrder> orders) {
        this.orders = new ArrayList<>(orders);
    }

    public void addCoffeOrder(CoffeeOrder order) {
        orders.add(order);
    }

    public BigDecimal getTotalIncome() {
        return orders.stream().flatMap(x -> x.getCoffeeList().stream())
                .map(x -> x.price).reduce(BigDecimal.ZERO, (a, b) -> a.add(b), (x, y) -> x.add(y)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalIncome(LocalDate date) {
        return orders.stream()
                .filter(x -> x.getDateTime().toLocalDate().equals(date))
                .flatMap(x -> x.getCoffeeList().stream())
                .map(x -> x.price).reduce(BigDecimal.ZERO, (a, b) -> a.add(b), (x, y) -> x.add(y)).setScale(2, RoundingMode.HALF_UP);
    }

    public long getNumberOfCoffee(CoffeeType coffeeType) {
        return orders.stream()
                .flatMap(x -> x.getCoffeeList().stream())
                .filter(x -> x.getCoffeeType().equals(coffeeType))
                .count();
    }

    public Collection<Object> getOrdersAfter(LocalDateTime dateTime) {
        return orders.stream()
                .filter(x -> x.getDateTime().isAfter(dateTime))
                .collect(Collectors.toList());
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate localDate) {
        return orders.stream()
                .filter(x -> x.getDateTime().toLocalDate().equals(localDate))
                .sorted(Comparator.comparing(CoffeeOrder::getDateTime))
                .limit(5)
                .collect(Collectors.toList());
    }

    public Map<CoffeeType, Long> getCountByCoffeeType() {
        return orders.stream()
                .flatMap(x -> x.getCoffeeList().stream())
                .collect(Collectors.groupingBy(Coffee::getCoffeeType, Collectors.counting()));
    }

    public double getAverageOrder() {
        return orders.stream()
                .collect(Collectors.averagingDouble(o -> o.getCoffeeList().size()));
    }
}
