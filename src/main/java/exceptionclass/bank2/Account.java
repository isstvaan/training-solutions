package exceptionclass.bank2;

public class Account {
    private String accountNumber;
    private double balance;
    private double maxSubtract;

    public Account(String accountNumber, double balance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        maxSubtract = 100_000;
    }

    public double subtract(double value) {
        if (value < 1) {
            throw new InvalidAmountBankOperationException("");
        }

        if (value < maxSubtract && balance > value) {
            balance -= value;
        } else {
            throw new LowBalanceBankOperationException("");
        }
        return balance;
    }

    public double deposit(double value) {
        if (value < 1) {
            throw new InvalidAmountBankOperationException("");
        }
        balance += value;
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }

    public void setMaxSubtract(double maxSubtract) {
        if (maxSubtract < 1) {
            throw new InvalidAmountBankOperationException("");
        }
        this.maxSubtract = maxSubtract;
    }
}
