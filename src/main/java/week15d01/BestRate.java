package week15d01;

import java.util.List;

public class BestRate {

    private int buyingDay;
    private int sellingDay;

    public BestRate(int buyingDay, int sellingDay) {
        this.buyingDay = buyingDay;
        this.sellingDay = sellingDay;
    }

    public int getBuyingDay() {
        return buyingDay;
    }

    public int getSellingDay() {
        return sellingDay;
    }

    @Override
    public String toString() {
        return "BestRate{" +
                "buyingDay=" + buyingDay +
                ", sellingDay=" + sellingDay +
                '}';
    }
}
