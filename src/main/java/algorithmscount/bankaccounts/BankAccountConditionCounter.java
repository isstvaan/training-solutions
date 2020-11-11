package algorithmscount.bankaccounts;

import java.util.List;

public class BankAccountConditionCounter {
    public int getHigherBalancesCount(List<BankAccount> bankAccounts, int minBalance) {
        int counter = 0;
        for (BankAccount account : bankAccounts) {
            if (account.getBalance() > minBalance) {
                counter++;
            }
        }

        return counter;
    }
}
