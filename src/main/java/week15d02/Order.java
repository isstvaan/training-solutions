package week15d02;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Order {
    private String address;
    private LocalTime time;

    public Order(String address, LocalTime time) {
        this.address = address;
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "address='" + address + '\'' +
                ", time=" + time +
                '}';
    }
}
