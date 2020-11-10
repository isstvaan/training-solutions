package attributes.book;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("Kezdö cim");

        System.out.printf(book.getTitle());

        book.setTitle("Módositott cim");

        System.out.printf(book.getTitle());

    }
}
