package ioreadstring.transaction;

public class BankAccount {
    private String name;
    private String accountNumber;
    private long balance;

    public BankAccount(String name, String accountNumber, long balance) {
        if (!isValid(name) || !isValid(accountNumber) || !isValid(balance)) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long amount) {
        this.balance += amount;
    }

    public String getName() {
        return name;
    }

    private boolean isValid(Object obj) {
        if (obj instanceof String) {
            return obj != null && !((String) obj).isBlank();
        }
        if (obj instanceof Long) {
            return obj != null && ((Long) obj) > -1;
        }
        return false;
    }
}
