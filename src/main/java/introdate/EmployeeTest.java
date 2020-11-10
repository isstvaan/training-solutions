package introdate;

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adja meg a dolgozó nevét:");
        String name = scanner.nextLine();

        System.out.println("Adja meg a dolgozó születési évét:");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Adja meg a dolgozó születési hónapját:");
        int month = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Adja meg a dolgozó születési napját:");
        int day = scanner.nextInt();
        scanner.nextLine();

        Employee employee = new Employee(year, month, day, name);

        System.out.println("A dolgozó adatai:\n" +
                "Név: " + employee.getName() + "\n" +
                "Születési idő: " + employee.getDateOfBirth() + "\n" +
                "Munkábaállás ideje: " + employee.getBeginEmployement() + "\n");

    }
}
