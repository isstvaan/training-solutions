package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Felhasználó regisztráció:");

        System.out.println("Kérem adja meg a felhasználó nevét:");
        String name= scanner.nextLine();

        System.out.println("Kérem adja meg a felhasználó e-mail címét:");
        String email= scanner.nextLine();

        System.out.println("\nA regisztrációnál megadott adatok:");
        System.out.println("Név: "+name);
        System.out.println("E-mail: "+email);
    }
}
