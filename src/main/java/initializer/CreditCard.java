package initializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreditCard {
    public static final List<Rate> RATES;

    static {
        RATES = Arrays.asList(
                new Rate(Currency.HUF, 1.0),
                new Rate(Currency.EUR, 308.23),
                new Rate(Currency.SFR, 289.24),
                new Rate(Currency.GBP, 362.23),
                new Rate(Currency.USD, 289.77));
    }

    private long balance;
    private Currency currency;

    public CreditCard(long balance, Currency currency) {
        this.currency = currency;
        this.balance = Math.round(balance * getConversionRate(currency));
    }

    public CreditCard(long balance) {
        this(balance, Currency.HUF);
    }

    public boolean payment(long amount) {
        return payment(amount, Currency.HUF);
    }

    public boolean payment(long amount, Currency currency) {
        long value = Math.round(amount * getConversionRate(currency));
        if (value <= balance) {
            balance -= value;
            return true;
        }
        return false;
    }

    private double getConversionRate(Currency currency) {
        for (Rate rate : RATES) {
            if (rate.getCurrency() == currency) {
                return rate.getRate();
            }
        }
        return 1.0;
    }

    public long getBalance() {
        return balance;
    }
}
