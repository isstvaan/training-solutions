package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    List<CoffeeOrder> orders;

    public Cafe(List<CoffeeOrder> orders) {
        this.orders = new ArrayList<>(orders);
    }

    public BigDecimal getTotalIncome() {
        return orders.stream().flatMap(x -> x.getCoffees().stream())
                .map(x -> x.price).reduce(BigDecimal.ZERO, (a, b) -> a.add(b), (x, y) -> x.add(y)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalIncome(LocalDate date) {
        return orders.stream()
                .filter(x -> x.getDateTime().toLocalDate().equals(date))
                .flatMap(x -> x.getCoffees().stream())
                .map(x -> x.price).reduce(BigDecimal.ZERO, (a, b) -> a.add(b), (x, y) -> x.add(y)).setScale(2, RoundingMode.HALF_UP);
    }

    public long getNumberOfCoffee(CoffeeType coffeeType) {
        return orders.stream()
                .flatMap(x -> x.getCoffees().stream())
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
}
