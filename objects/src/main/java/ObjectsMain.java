import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMain {

    public static void main(String[] args) {

        new Book();

        System.out.println(new Book());//HEAP cimet ad vissza

        Book emptyBook = null;

        System.out.println(emptyBook);//null

        Book book = new Book();

        System.out.println(book);//HEAP cim

        book = null;

        System.out.println(book);//null

        book = new Book();

        System.out.println(book);//HEAP cim

        Book anotherBook = new Book();
        anotherBook = book;

        System.out.println(book == anotherBook);//true

        System.out.println(anotherBook instanceof Book);//true

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = book1;
        Book book5 = book1;
        Book book6 = book3;
        Book book7 = null;
        book4 = book5;
        book5 = new Book();
        book6 = null;

        //3 objektumot hoz létre osszesen, a többi csak hivatkozás
        Book[] books = {new Book(), new Book(), new Book()};
        List<Book> booksListConst = Arrays.asList(new Book(), new Book());

        List<Book> booksDynamicList = new ArrayList<>();
        booksDynamicList.add(new Book());
        booksDynamicList.add(new Book());
        booksDynamicList.add(new Book());
    }
}
