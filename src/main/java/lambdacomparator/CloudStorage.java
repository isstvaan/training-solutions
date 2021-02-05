package lambdacomparator;

public class CloudStorage implements Comparable<CloudStorage> {
    private final String provider;
    private final int space;
    private double price;
    private PayPeriod payPeriod;
    private double pricePerYearPer1000GB = 0;


    public CloudStorage(String provider, int space, PayPeriod payPeriod, double price) {
        this.provider = provider;
        this.space = space;
        this.price = price;
        this.payPeriod = payPeriod;

        pricePerYearPer1000GB = this.price * 12 / this.payPeriod.getLength() / this.space * 1000;
    }

    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
    }

    public PayPeriod getPeriod() {
        return payPeriod;
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(CloudStorage o) {
        return Double.compare(this.pricePerYearPer1000GB, o.pricePerYearPer1000GB);
    }
}
