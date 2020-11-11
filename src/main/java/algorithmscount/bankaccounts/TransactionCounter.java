package algorithmscount.bankaccounts;

import java.util.List;

public class TransactionCounter {
    public int getSmallerThanTransactionsCount(List<Transaction> transactions, int maxValue) {
        int counter = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < maxValue)
                counter++;
        }
        return counter;
    }
}
