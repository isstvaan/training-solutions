package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class OrderedArrayLibrary {
    private final Book[] bookArray;

    public OrderedArrayLibrary(Book[] bookArray) {
        this.bookArray = bookArray.clone();
    }

    public Book[] sortingById() {
        Book[] retVal = bookArray.clone();
        Arrays.sort(retVal);
        return retVal;
    }

    public Book[] sortingByTitle() {
        Book[] retVal = bookArray.clone();
        Arrays.sort(retVal, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return retVal;
    }
}
