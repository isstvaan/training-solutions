package exampractice;

public class DeveloperSoftware extends Software {
    public DeveloperSoftware(String name, double price) {
        super(name, price);
    }

    @Override
    public void increasePrice() {
        price *= 1.1;
    }
}
