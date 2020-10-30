import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adjon meg egy számot, és megmondom hogy osztható-e hárommal:");
        System.out.println("A megadott szám osztható hárommal: " + (scanner.nextInt() % 3 == 0));

    }
}
