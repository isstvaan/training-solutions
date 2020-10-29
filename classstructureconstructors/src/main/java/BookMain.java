import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book("Teszt Elek", "Teszt könyv");
        System.out.println("Kérem adja meg a " + book.getAuthor() + " szerzőtől a " + book.getTitle() + " című könyv regisztrációs számát:");
        book.register(scanner.nextLine());

        System.out.println("A könyv adatai:\n" +
                "Szerző: " + book.getAuthor() +
                "Cím: " + book.getTitle() +
                "Regisztrációs szám: " + book.getRegNumber());

    }
}
