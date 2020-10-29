import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculator:");
        System.out.println("Kérem adjon meg két egész számot az összeadáshoz");

        System.out.println("Első szám:");
        int x= scanner.nextInt();

        System.out.println("Második szám:");
        int y = scanner.nextInt();

        System.out.println(x + " + " +y);
        System.out.println(x + y);
    }
}
