import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();

        System.out.println("Kérem adja meg a kliens nevét:");
        client.setName(scanner.nextLine());

        System.out.println("Kérem adja meg a kliens születési évét:");
        client.setYear(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Kérem adja meg a kliens címét:");
        client.setAddress(scanner.nextLine());

        System.out.println("A kliens adatai:\r\n" +
                "\tNév: " + client.getName() + "\r\n" +
                "\tSzületési év: " + client.getYear() + "\r\n" +
                "\tAddress: " + client.getAddress() + "\r\n");

        System.out.println("Kérem adja meg a kliens megváltozott címét:");
        client.migrate(scanner.nextLine());

        System.out.println("A cím sikeresen módosult:\r\n" + client.getAddress());
    }
}
