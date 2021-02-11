package week15d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Couriers {
    private String name;
    private List<Order> orders = new ArrayList<>();

    public Couriers(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void addOrders(List<Order> orders) {
        this.orders.addAll(orders);
    }

    @Override
    public String toString() {
        return "Couriers{" +
                "name='" + name + '\'' +
                ", orders=" + orders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Couriers couriers = (Couriers) o;
        return Objects.equals(name, couriers.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
