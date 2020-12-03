package iofilestest.library;

public class Book {
    private String author;
    private String title;

    public Book(String author, String title) {
        if (!isValid(author)) {
            throw new IllegalArgumentException("Author is null or empty");
        }
        if (!isValid(title)) {
            throw new IllegalArgumentException("Title is null or empty");
        }
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    private boolean isValid(String str) {
        return str != null && !str.isBlank();
    }

    @Override
    public String toString() {
        return author + ";" + title;
    }
}
