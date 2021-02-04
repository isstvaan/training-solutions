package week11d02;

import java.util.Objects;

public class Ride implements Comparable<Ride> {
    public static final int MAX_RIDE = 100;
    private int day;
    private int task;
    private int distance;

    public Ride(int day, int task, int distance) {
        this.day = day;
        this.task = task;
        this.distance = distance;
    }

    public int getDay() {
        return day;
    }

    public int getTask() {
        return task;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Ride o) {
        return (this.day * MAX_RIDE + this.task) - (o.day * MAX_RIDE + o.task);
    }

    @Override
    public String toString() {
        return "Ride{" +
                "day=" + day +
                ", task=" + task +
                ", distance=" + distance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return day == ride.day &&
                task == ride.task &&
                distance == ride.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, task, distance);
    }
}
