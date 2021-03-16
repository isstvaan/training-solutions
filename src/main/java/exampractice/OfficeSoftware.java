package exampractice;

public class OfficeSoftware extends Software {
    public OfficeSoftware(String name, double price) {
        super(name, price);
    }

    @Override
    public void increasePrice() {
        price *= 0.05;
    }
}
