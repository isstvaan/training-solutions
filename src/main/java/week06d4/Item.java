package week06d4;

public class Item {
    private String name;
    private int quantity;

    public Item(String name, int quantity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or empty");
        }

        this.name = name;
        this.quantity = quantity;
    }

    public void addQuantity(int value) {
        quantity += value;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}
