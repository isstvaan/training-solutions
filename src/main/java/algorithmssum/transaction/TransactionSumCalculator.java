package algorithmssum.transaction;

import java.util.List;

public class TransactionSumCalculator {
    public int sumAmountOfCreditEntries(List<Transaction> transactions) {
        int sumValue = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionOperation() == TransactionOperation.CREDIT) {
                sumValue += transaction.getAmount();
            }
        }
        return sumValue;
    }
}
