package lambdaprimitives;

public class Product {
    private final String name;
    private final double price;
    private final int count;

    public Product(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}
