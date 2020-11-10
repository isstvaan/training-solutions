package classstructureattributes.client;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();

        System.out.println("Kérem adja meg a kliens nevét:");
        client.name = scanner.nextLine();

        System.out.println("Kérem adja meg a kliens születési évét:");
        client.year = scanner.nextInt();
        client.address = scanner.nextLine();

        System.out.println("Kérem adja meg a kliens címét:");
        client.address = scanner.nextLine();

        System.out.println("\nA kliens adatai:\nNév: "+client.name
                + "\nSzületési év: "+client.year
                + "\nCím: "+client.address);

    }
}
