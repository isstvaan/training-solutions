package initializer;

public class Rate {
    private Currency currency;
    private double factor;

    public Rate(Currency currency, double factor) {
        this.currency = currency;
        this.factor = factor;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getFactor() {
        return factor;
    }
}
