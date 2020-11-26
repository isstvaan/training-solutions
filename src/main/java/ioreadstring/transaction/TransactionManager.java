package ioreadstring.transaction;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    List<BankAccount> accounts = new ArrayList<>();

    public void uploadListFromFile(String path) {
        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            for (String line : lines) {
                accounts.add(getBankAccountFromString(line));
            }
        } catch (IOException ex) {
            throw new IllegalStateException("File not found", ex);
        }
    }

    public void makeTransactions(String path) {
        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            for (String line : lines) {
                doTransaction(line);
            }
        } catch (IOException ex) {
            throw new IllegalStateException("File not found", ex);
        } catch (
                NumberFormatException e) {
            throw new IllegalStateException("Invalid format", e);
        }
    }

    private void doTransaction(String transStr) {
        String[] splittedStr = transStr.split(";");
        BankAccount foundedAccount = findBankAccount(splittedStr[0]);
        if (foundedAccount != null) {
            foundedAccount.setBalance(Long.parseLong(splittedStr[1]));
        }
    }

    private BankAccount findBankAccount(String accountNumber) {
        for (BankAccount item : accounts) {
            if (item.getAccountNumber().equals(accountNumber)) {
                return item;
            }
        }

        return null;
    }

    private BankAccount getBankAccountFromString(String str) {
        String[] splittedStr = str.split(";");
        return new BankAccount(splittedStr[0], splittedStr[1], Long.parseLong(splittedStr[2]));
    }

    public List<BankAccount> getAccountList() {
        return accounts;
    }
}
