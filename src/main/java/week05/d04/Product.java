package week05.d04;

public class Product {
    private long price;
    private Currency currency;

    public Product(int price, Currency currency) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be positive.");
        }
        if (currency == null) {
            throw new IllegalArgumentException("Currency can't be null.");
        }

        this.price = price * currency.getConvertFactor();
        this.currency = currency;
    }

    public double convertPrice(Currency currency) {
        return (double) price / currency.getConvertFactor();
    }

}
