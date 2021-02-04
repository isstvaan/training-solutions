package week12d01;

public class Packet implements Comparable<Packet> {
    private final int weight;
    private final int price;

    public Packet(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Packet o) {
        return Double.compare((double) price / weight, (double) o.price / o.weight);
    }
}
