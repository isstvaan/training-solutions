package collectionsequalshash;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {
    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {
        for (Book item : books) {
            if (item.getAuthor().equals(author) && item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }

    public Book findBook(List<Book> books, Book book) {
        for (Book item : books) {
            if (item.equals(book)) {
                return item;
            }
        }
        return null;
    }

    public Set<Book> addBooksToSet(Book[] books) {
        Set<Book> bookSet = new HashSet<>();
        Collections.addAll(bookSet, books);
        return bookSet;
    }
}
