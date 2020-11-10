package introcontrol;

import java.util.Scanner;

public class Qualifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem adjon meg egy számot:");

        int number = scanner.nextInt();

        System.out.println(number > 100 ? "nagyobb. mint száz" : "száz, vagy kisebb");
    }
}
