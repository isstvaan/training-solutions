package registration;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserValidator userValidator = new UserValidator();

        System.out.println("Adja meg a felhasználó nevét:");
        System.out.println("A felhasználói név " + (userValidator.isValidUsername(scanner.nextLine()) ? "helyes" : "helytelen"));

        System.out.println("Adja meg a jelszót:");
        String password = scanner.nextLine();

        System.out.println("Erősítse meg a jelszót:");
        System.out.println("A megadott jelszó " + (userValidator.isValidPassword(password, scanner.nextLine()) ? "megfelelő" : "nem megfelelő"));

        System.out.println("Adja meg az email címet:");
        System.out.println("A megadott email cím " + (userValidator.isValidEmail(scanner.nextLine()) ? "megfelelő" : "nem megfelelő"));

    }


}
