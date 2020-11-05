import java.util.Scanner;

public class CircleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem adja meg az első kőr átmérőjét:");
        Circle circle1 = new Circle(scanner.nextInt());
        scanner.nextLine();
        System.out.println("A kör kerülete: " + circle1.permiter() + "\nA kör területe: " + circle1.area() + "\n");

        System.out.println("Kérem adja meg a második kőr átmérőjét:");
        Circle circle2 = new Circle(scanner.nextInt());
        scanner.nextLine();
        System.out.println("A kör kerülete: " + circle2.permiter() + "\nA kör területe: " + circle2.area() + "\n");
    }
}
