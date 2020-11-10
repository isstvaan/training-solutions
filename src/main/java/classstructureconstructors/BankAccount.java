package classstructureconstructors;

public class BankAccount {
    private String accountNumber;
    private String owner;
    private int balance;

    public BankAccount(String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public void transfer(BankAccount account, int amount) {
        withdraw(amount);
        account.deposit(amount);
    }

    public String getIngo() {
        return owner + " (" + accountNumber + "): " + balance + " Ft";
    }
}
