package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {
    Set<Book> libraryBooks;

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = new HashSet<>(libraryBooks);
    }

    public Book findBookByRegNumber(int regNumber) {
        for (Book item : libraryBooks) {
            if (item.getRegNumber() == regNumber) {
                return item;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public int removeBookByRegNumber(int regNumber) {
        for (Iterator<Book> i = libraryBooks.iterator(); i.hasNext(); ) {
            Book item = i.next();
            if (item.getRegNumber() == regNumber) {
                i.remove();
                return regNumber;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> retVal = new HashSet<>();
        for (Iterator<Book> item = libraryBooks.iterator(); item.hasNext(); ) {
            Book bookItem = item.next();
            if (bookItem.getAuthor().equals(author)) {
                retVal.add(bookItem);
            }
        }
        if (retVal.isEmpty()) {
            throw new MissingBookException("No books found by " + author);
        }
        return retVal;
    }

    public int libraryBooksCount() {
        return libraryBooks.size();
    }
}
