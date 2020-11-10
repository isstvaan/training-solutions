package finalmodifier;

public class TaxCalculator {
    public static final double TAX = .27;

    public double tax(double price) {
        return price * TAX;
    }

    public double priceWithTax(double price) {
        return price + tax(price);
    }

    public static void main(String[] args) {
        System.out.println("100Ft adója: " + new TaxCalculator().tax(100));
        System.out.println("100Ft adóval emelt értéke: " + new TaxCalculator().priceWithTax(100));
    }
}
