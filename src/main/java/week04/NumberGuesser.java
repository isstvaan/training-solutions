package week04;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
    private static final int ROUNDS = 7;

    public static void main(String[] args) {
        Random random = new Random();
        int number = 1 + random.nextInt(99);
        System.out.println("Kitaláltam egy számot 1-100 között, van rá " + ROUNDS + " köröd");

        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        while (true) {
            counter++;
            System.out.println(counter + " kör: Ird be az általad preferáld számot:");
            int userNumber = scanner.nextInt();
            if (userNumber == number) {
                System.out.println("Gratulálok kitaláltad: " + number);
                return;
            }
            System.out.println("Nem talált, az én számom ennél: " + (number > userNumber ? "nagyobb" : "kisebb"));

            if (counter >= ROUNDS) {
                System.out.println("Vesztettél, a helyes szám " + number + " lett volna");
                return;
            }
        }
    }
}
