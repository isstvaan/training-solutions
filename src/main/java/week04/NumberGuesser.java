package week04;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

    public static void main(String[] args) {
        Random random = new Random();
        int number = 1 + random.nextInt(99);
        System.out.println("Kitaláltam egy számot 1-100 között");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Ird be az általad preferáld számot:");
            int userNumber = scanner.nextInt();
            if (userNumber == number) {
                System.out.println("Gratulálok kitaláltad: " + number);
                return;
            }
            System.out.println("Nem talált, az én számom ennél: " + (number > userNumber ? "nagyobb" : "kisebb"));
        }
    }
}
