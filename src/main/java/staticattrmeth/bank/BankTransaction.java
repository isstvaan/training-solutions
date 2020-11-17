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

        currentMinValue = trxValue < currentMinValue ? trxValue : currentMinValue;
        currentMaxValue = trxValue > currentMaxValue ? trxValue : currentMaxValue;

        transactions.add(this);
    }

    public long getTrxValue() {
        return trxValue;
    }

    public static void initTheDay() {
        transactions.clear();
        currentMaxValue = MIN_TRANS;
        currentMinValue = MAX_TRANS;
    }

    public static BigDecimal averageOfTransaction() {
        return getSumOfTrxs().divide(new BigDecimal(transactions.size()));
    }

    public static long getCurrentMinValue() {
        return transactions.size() > 0 ? currentMinValue : 0;
    }

    public static long getCurrentMaxValue() {
        return transactions.size() > 0 ? currentMaxValue : 0;
    }

    public static BigDecimal getSumOfTrxs() {
        BigDecimal sumTransactions = new BigDecimal(0);

        for (BankTransaction item : transactions) {
            sumTransactions = sumTransactions.add(new BigDecimal(item.getTrxValue()));
        }
        return sumTransactions;
    }

}
