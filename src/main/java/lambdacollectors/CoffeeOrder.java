package lambdacollectors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CoffeeOrder {
    private List<Coffee> coffees;
    private LocalDateTime dateTime;

    public CoffeeOrder(List<Coffee> coffees, LocalDateTime dateTime) {
        this.coffees = new ArrayList<>(coffees);
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public List<Coffee> getCoffeeList() {
        return coffees;
    }
}
