package inheritancemethods.bankaccount;

public class DebitAccount {
    private static final double COST = 3.0;
    private static final long MIN_COST = 200;

    private String accountNumber;
    private long balance;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public final long costOfTransaction(long amount) {
        long transCost = (long) (amount * COST / 100f);
        return transCost > MIN_COST ? transCost : MIN_COST;
    }

    public boolean transaction(long amount) {
        long sumTrans = amount + costOfTransaction(amount);
        if (sumTrans <= balance) {
            balance -= sumTrans;
            return true;
        }
        return false;
    }

    public void balanceToZero() {
        balance = 0;
    }
}
