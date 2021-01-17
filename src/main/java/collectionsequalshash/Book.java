package collectionsequalshash;

import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final String regNumber;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        regNumber = "";
    }

    public Book(String regNumber, String title, String author) {
        this.title = title;
        this.author = author;
        this.regNumber = regNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getRegNumber() {
        return regNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "regNumber='" + regNumber + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
