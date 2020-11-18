package introinheritance.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item can't be null.");
        }
        items.add(item);
    }

    public void removeItem(String barcode) {
        if (barcode == null || barcode.isBlank()) {
            throw new IllegalArgumentException("Barceode can't be empty.");
        }

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getBarcode().equalsIgnoreCase(barcode)) {
                items.remove(i);
                return;
            }
        }
    }

    public void clearBasket() {
        items.clear();
    }

    public List<Item> getItems() {
        return items;
    }
}
