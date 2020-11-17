package methodstructure.pendrives;

public class Pendrive {
    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public void risePrice(int percent) {
        price = Double.valueOf(price * (1 + (percent / 100f))).intValue();
    }

    public int comparePricePerCapacity(Pendrive pendrive) {
        double currentPricePerCapacity = price / (double) capacity;
        double pricePerCapacity = pendrive.getPrice() / (double) pendrive.getCapacity();

        if (currentPricePerCapacity > pricePerCapacity) {
            return 1;
        } else if (currentPricePerCapacity < pricePerCapacity) {
            return -1;
        }

        return 0;
    }

    public boolean cheaperThan(Pendrive pendrive) {
        return price < pendrive.getPrice();
    }

    @Override
    public String toString() {
        return name + ": " + capacity + " " + price;
    }
}
