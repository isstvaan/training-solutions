package exceptionclass.bank;

import exceptionclass.bank2.InvalidAmountBankOperationException;

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
            throw new InvalidBankOperationException("", ErrorCode.INVALID_AMOUNT);
        }

        if (value < maxSubtract && balance > value) {
            balance -= value;
        } else {
            throw new InvalidBankOperationException("", ErrorCode.LOW_BALANCE);
        }
        return balance;
    }

    public double deposit(double value) {
        if (value < 1) {
            throw new InvalidBankOperationException("", ErrorCode.INVALID_AMOUNT);
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
            throw new InvalidBankOperationException("", ErrorCode.INVALID_AMOUNT);
        }
        this.maxSubtract = maxSubtract;
    }
}
