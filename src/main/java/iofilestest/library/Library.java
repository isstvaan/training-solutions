package iofilestest.library;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book can't be null");
        }
        if (!bookIsExists(book)) {
            books.add(book);
        }
    }

    public void saveBooks(Path savePath) {
        if (savePath == null) {
            throw new IllegalArgumentException("Path can't be null");
        }

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(savePath, StandardOpenOption.CREATE)))) {
            for (Book item : books) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file", e);
        }
    }

    public void loadBooks(Path loadPath) {
        if (loadPath == null) {
            throw new IllegalArgumentException("Path can't be null");
        }

        if (!Files.exists(loadPath)) {
            throw new IllegalArgumentException("File is not exists");
        }

        books.clear();
        try {
            List<String> lines = Files.readAllLines(loadPath);
            for (String item : lines) {
                String[] splitStr = item.split(";");
                if (splitStr.length > 1) {
                    addBook(new Book(splitStr[0], splitStr[1]));
                } else {
                    throw new IllegalStateException("Invalid file data.");
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file.", e);
        }

    }

    private boolean bookIsExists(Book book) {
        for (Book item : books) {
            if (item.getAuthor().equals(book.getAuthor()) &&
                    item.getTitle().equals(book.getTitle())) {
                return true;
            }
        }
        return false;
    }

    public List<Book> getBooks() {
        return books;
    }
}
