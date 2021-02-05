package classstructureintegrate;

import java.util.Scanner;

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
        balance = balance + amount;
    }

    public void withdraw(int amount) {
        balance = balance - amount;
    }

    public void transfer(BankAccount to, int amount) {
        withdraw(amount);
        to.deposit(amount);
    }

    public String getInfo() {
        return owner + " (" + accountNumber + "):" + balance + " Ft";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mi az új számla száma?");
        String accountNumber = scanner.nextLine();

        System.out.println("Ki a tulajdonos?");
        String owner = scanner.nextLine();

        System.out.println("Mekkora összeggel nyitja?");
        int amount = scanner.nextInt();
        scanner.nextLine();

        BankAccount account1 = new BankAccount(accountNumber, owner, amount);

        System.out.println("Mi az új számla száma?");
        String accountNumber2 = scanner.nextLine();

        System.out.println("Ki a tulajdonos?");
        String owner2 = scanner.nextLine();

        System.out.println("Mekkora összeggel nyitja?");
        int amount2 = scanner.nextInt();

        BankAccount account2 = new BankAccount(accountNumber2, owner2, amount2);

        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());

        System.out.println("Mennyit szeretne befizetni az első számlára?");
        int depositAmount = scanner.nextInt();
        account1.deposit(depositAmount);

        System.out.println(account1.getInfo());

        System.out.println("Mennyit szeretne felvenni a második számláról?");
        int withdrawAmount = scanner.nextInt();
        account2.withdraw(withdrawAmount);

        System.out.println(account2.getInfo());

        System.out.println("Mennyit szeretne átutalni az első számláról a másodikra?");
        int transferAmount = scanner.nextInt();
        account1.transfer(account2, transferAmount);

        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());
    }
}
