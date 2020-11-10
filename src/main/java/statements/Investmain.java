package statements;

import java.util.Scanner;

public class Investmain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Befektetni kívánt összeg:");
        int amount = scanner.nextInt();

        System.out.println("Befektetés kamatlába:");
        int interestRate = scanner.nextInt();

        Investment investment = new Investment(amount, interestRate);

        System.out.println("Tőke: " + investment.getFund());
        System.out.println("Hozam 100 napra: " + investment.getYield(100));
        System.out.println("Kivett összeg 50 nap után: " + investment.close(50));
        System.out.println("Kivett összeg 100 nap után: " + investment.close(100));
    }
}
