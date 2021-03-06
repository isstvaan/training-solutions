package exceptionclass.bank;

import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank(List<Account> accounts) {
        if (accounts == null) {
            throw new IllegalArgumentException("");
        }
        this.accounts = accounts;
    }

    public void payment(String accountNumber, double value) {
        for (Account item : accounts) {
            if (item.getAccountNumber().equals(accountNumber)) {
                item.subtract(value);
                return;
            }
        }
        throw new InvalidBankOperationException("", ErrorCode.INVALID_ACCOUNTNUMBER);
    }

    public void deposit(String accountNumber, double value) {
        for (Account item : accounts) {
            if (item.getAccountNumber().equals(accountNumber)) {
                item.deposit(value);
                return;
            }
        }
        throw new InvalidBankOperationException("", ErrorCode.INVALID_ACCOUNTNUMBER);
    }

}
