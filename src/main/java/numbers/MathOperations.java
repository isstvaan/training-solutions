package numbers;

import java.util.Scanner;

public class MathOperations {
    public final static double DELTA = 0.0001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mi az alábbi feladat megoldása?");
        System.out.println("X = 6 + 4 * 3 - (2 * 8) / 2");
        System.out.println("X?:");

        double x = 6 + 4 * 3 - (2 * 8) / 2.0;

        System.out.println("A megoldás: " + (Math.abs(x - scanner.nextDouble()) < DELTA ? "helyes" : "helytelen, a helyes válasz: " + x));
    }
}
