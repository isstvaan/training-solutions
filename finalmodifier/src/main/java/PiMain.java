import java.util.Scanner;

public class PiMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kör sugara:");
        int r = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Kör kerülete:" + new CircleCalculator().calculatePerimeter(r));
        System.out.println("Kör tetülete:" + new CircleCalculator().calculateArea(r));

        System.out.println("Henger sugara:");
        r = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Henger magassága:");
        int h = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Henger felszíne:" + new CylinderCalculator().calculateSurfaceArea(r, h));
        System.out.println("Henger térfogata:" + new CylinderCalculator().calculateVolume(r, h));

        System.out.println("Pi értéke: " + CircleCalculator.MATH_PI);

        //Bonusz
        System.out.println("Kör kerülete:" + new CircleCalculator().calculatePerimeter(10));

    }
}
