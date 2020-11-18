package introinheritance.basket;

public class ShoppingBasket {
    private Basket basket = new Basket();

    public void addItem(Item item) {
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {
        double sumNetto = 0;
        for (Item item : basket.getItems()) {
            sumNetto += item.getNettoPrice();
        }
        return sumNetto;
    }

    public double sumTaxValue() {
        double sumTax = 0;
        for (Item item : basket.getItems()) {
            sumTax += item.getTaxAmount();
        }
        return sumTax;
    }

    public double sumBruttoPrice() {
        return sumNettoPrice() + sumTaxValue();
    }

    public void checkout() {
        basket.clearBasket();
    }

    public void removeMostExpensiveItem() {
        Item mostExpensiveItem = null;
        for (Item item : basket.getItems()) {
            mostExpensiveItem = mostExpensiveItem == null ? item :
                    mostExpensiveItem.getNettoPrice() + mostExpensiveItem.getTaxAmount() <
                            item.getNettoPrice() + item.getTaxAmount() ?
                            item : mostExpensiveItem;
        }
        if (mostExpensiveItem != null) {
            basket.getItems().remove(mostExpensiveItem);
        }
    }
}
