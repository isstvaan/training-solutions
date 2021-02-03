package collectionscomp;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class OrderedLibrary {
    List<Book> libraryBooks;

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = new ArrayList<>(libraryBooks);
    }

    public List<Book> orderedByTitle() {
        List<Book> retVal = new ArrayList<>(libraryBooks);
        Collections.sort(retVal);
        return retVal;
    }

    public List<Book> orderedByAuthor() {
        List<Book> retVal = new ArrayList<>(libraryBooks);
        retVal.sort(new AuthorComparator());
        return retVal;
    }

    public List<String> orderedByTitleLocale(Locale locale) {
        List<String> retVal = new ArrayList<>();
        for (Book book : libraryBooks) {
            retVal.add(book.getTitle());
        }

        Collections.sort(retVal, Collator.getInstance(locale));
        return retVal;
    }
}
