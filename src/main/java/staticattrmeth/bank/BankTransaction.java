package staticattrmeth.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankTransaction {
    public static final long MIN_TRANS = 1;
    public static final long MAX_TRANS = 10_000_000;

    private static long currentMinValue;
    private static long currentMaxValue;

    private static List<BankTransaction> transactions = new ArrayList<>();

    private long trxValue;

    public BankTransaction(long trxValue) {
        this.trxValue = trxValue;

        if (currentMaxValue == 0) {
            currentMaxValue = MIN_TRANS;
        }
        if (currentMinValue == 0) {
            currentMinValue = MAX_TRANS;
        }

        currentMinValue = trxValue < currentMinValue ? trxValue : currentMinValue;
        currentMaxValue = trxValue > currentMaxValue ? trxValue : currentMaxValue;

        transactions.add(this);
    }

    public long getTrxValue() {
        return trxValue;
    }

    public static void initTheDay() {
        transactions.clear();
        currentMaxValue = 0;
        currentMinValue = 0;
    }

    public static BigDecimal averageOfTransaction() {
        return getSumOfTrxs().divide(new BigDecimal(transactions.size()));
    }

    public static long getCurrentMinValue() {
        return currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return currentMaxValue;
    }

    public static BigDecimal getSumOfTrxs() {
        BigDecimal sumTransactions = new BigDecimal(0);

        for (BankTransaction item : transactions) {
            sumTransactions = sumTransactions.add(new BigDecimal(item.getTrxValue()));
        }
        return sumTransactions;
    }

}
