package iofilestest.cheese;

public class Cheese {
    private String name;
    private double lactose;

    public Cheese(String name, double lactose) {
        this.name = name;
        this.lactose = lactose;
    }

    public String getName() {
        return name;
    }

    public double getLactose() {
        return lactose;
    }

    @Override
    public String toString() {
        return name + ";" + lactose;
    }
}
