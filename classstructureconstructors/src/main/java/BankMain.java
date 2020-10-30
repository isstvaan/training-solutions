import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount bankAccount1, bankAccount2;

        System.out.println("Kérem adja meg az első bankszámla tulajdonosának nevét:");
        String name = scanner.nextLine();

        System.out.println("Kérem adja meg az első bankszámla számlaszámát:");
        String accountNumber = scanner.nextLine();

        System.out.println("Kérem adja meg az első bankszámla egyenlegét:");
        int balance = scanner.nextInt();
        scanner.nextLine();

        bankAccount1 = new BankAccount(accountNumber, name, balance);

        System.out.println("Kérem adja meg a második bankszámla tulajdonosának nevét:");
        name = scanner.nextLine();

        System.out.println("Kérem adja meg a második bankszámla számlaszámát:");
        accountNumber = scanner.nextLine();

        System.out.println("Kérem adja meg a második bankszámla egyenlegét:");
        balance = scanner.nextInt();
        scanner.nextLine();

        bankAccount2 = new BankAccount(accountNumber, name, balance);

        System.out.println("Az első bankszámla adatai: " + bankAccount1.getIngo());

        System.out.println("Befizetünk az első számlára 10 000 Ft-ot");
        bankAccount1.deposit(10000);
        System.out.println("Az első bankszámla adatai: " + bankAccount1.getIngo());


        System.out.println("Kiveszünk az első számláról 5 000 Ft-ot");
        bankAccount1.withdraw(5000);
        System.out.println("Az első bankszámla adatai: " + bankAccount1.getIngo());

        System.out.println("\n\nA második bankszámla adatai: " + bankAccount2.getIngo());

        System.out.println("Befizetünk a második számlára 100 000 Ft-ot");
        bankAccount2.deposit(100000);
        System.out.println("A második bankszámla adatai: " + bankAccount2.getIngo());


        System.out.println("Kiveszünk a második számláról 10 000 Ft-ot");
        bankAccount2.withdraw(10000);
        System.out.println("A második bankszámla adatai: " + bankAccount2.getIngo());

        System.out.println("\n\nAz első bankszámlára átutalunk 50 000 Ft-ot a második számláról");
        bankAccount2.transfer(bankAccount1, 50000);

        System.out.println("Az első bankszámla adatai: " + bankAccount1.getIngo());
        System.out.println("A második bankszámla adatai: " + bankAccount2.getIngo());

    }
}
