package collectionsclass;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CollectionManager {
    private List<Book> library;

    public CollectionManager(List<Book> bookList) {
        library = new ArrayList<>(bookList);
        Collections.sort(library);
    }

    public Book getFirstBook() //a legrégebbi (legkisebb id) könyvet adja vissza
    {
        return Collections.min(library);
    }

    public List<Book> createUnmodifiableLibrary() {
        return Collections.unmodifiableList(library);
    }

    public List<Book> reverseLibrary() //az eredeti lista másolatán dolgozik!
    {
        List<Book> retVal = new ArrayList<>(library);
        Collections.reverse(retVal);
        return retVal;
    }

    public Book getLastBook() // a legújabb (legnagyobb id) könyvet adja vissza
    {
        return Collections.max(library);
    }
}
