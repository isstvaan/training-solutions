import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem adjon meg 5 számot:");

        int tmp = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + ". szám:");
            tmp += scanner.nextInt();
        }

        System.out.println("A megadott számok összege: " + tmp);
    }
}
