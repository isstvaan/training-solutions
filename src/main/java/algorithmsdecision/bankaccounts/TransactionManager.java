package algorithmsdecision.bankaccounts;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionManager {
    public boolean containsCreditEntryGreaterThan(List<Transaction> transactions, LocalDateTime from, LocalDateTime to, int min) {
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionOperation() == TransactionOperation.DEBIT &&
                    from.isBefore(transaction.getDateOfTransaction()) &&
                    to.isAfter(transaction.getDateOfTransaction()) &&
                    transaction.getAmount() > min) {
                return true;
            }
        }
        return false;
    }

    public void makeTransactions(List<Transaction> transactions, List<BankAccount> accounts) {
        for (Transaction transaction : transactions) {
            BankAccount accountToTransfer = findBankAccount(accounts, transaction.getAccountNumber());
            if (accountToTransfer != null) {
                transact(transaction, accountToTransfer);
            } else {
                transaction.setNotExecutedSuccessfully();
            }
        }
    }

    private void transact(Transaction transaction, BankAccount accountRelatedToTransaction) {
        if (transaction.getTransactionOperation() == TransactionOperation.CREDIT) {
            accountRelatedToTransaction.deposit(transaction.getAmount());
            transaction.setExecutedSuccessfully();
        } else {
            if (accountRelatedToTransaction.withdraw(transaction.getAmount())) {
                transaction.setExecutedSuccessfully();
            } else {
                transaction.setNotExecutedSuccessfully();
            }
        }
    }

    private BankAccount findBankAccount(List<BankAccount> accounts, String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber))
                return account;
        }
        return null;
    }
}
