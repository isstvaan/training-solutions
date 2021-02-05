package lambdaintro;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class BankAccounts {
    List<BankAccount> accounts;

    public BankAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        List<BankAccount> retVal = new ArrayList<>(accounts);
        retVal.sort(Comparator.naturalOrder());
        return retVal;

    }

    public List<BankAccount> listBankAccountsByBalance() {
        List<BankAccount> retVal = new ArrayList<>(accounts);
        retVal.sort(Comparator.comparing(item -> Math.abs(item.getBalance())));
        return retVal;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        List<BankAccount> retVal = new ArrayList<>(accounts);
        retVal.sort(Comparator.comparing(BankAccount::getBalance).reversed());
        return retVal;
    }

    public List<BankAccount> listBankAccountsByNameThanAccountNumber() {
        List<BankAccount> retVal = new ArrayList<>(accounts);
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));

        retVal.sort(
                Comparator.comparing(BankAccount::getNameOfOwner,
                        Comparator.nullsFirst(collator))
                        .thenComparing(BankAccount::getAccountNumber));

        return retVal;

    }
}
