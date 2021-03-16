package exampractice;

public abstract class Software {
    private final String name;
    protected double price;

    public Software(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract void increasePrice();
}
