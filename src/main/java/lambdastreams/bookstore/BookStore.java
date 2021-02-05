package lambdastreams.bookstore;

import java.util.*;
import java.util.stream.Collectors;

public class BookStore {

    List<Book> books;

    public BookStore(List<Book> books) {
        this.books = new ArrayList<>(books);
    }

    public long getNumberOfBooks() {
        return books.stream().reduce(0, (x, y) -> x + y.getNumber(), Integer::sum);
    }

    public Optional<Book> findNewestBook() {
        return books.stream().max(Comparator.comparing(Book::getYearOfPublish));
    }

    public int getTotalValue() {
        return books.stream().reduce(0, (x, y) -> x + y.getPrice() * y.getNumber(), Integer::sum);
    }

    public List<Book> getByYearOfPublish(int year) {
        return books.stream().collect(Collectors.groupingBy(Book::getYearOfPublish)).get(year);

    }
}
