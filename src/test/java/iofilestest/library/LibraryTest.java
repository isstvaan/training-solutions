package iofilestest.library;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LibraryTest {

    @Rule
    public TemporaryFolder tmp = new TemporaryFolder();

    @Test
    public void testInvalidData() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Book(null, null));
        assertEquals("Author is null or empty", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new Book("", null));
        assertEquals("Author is null or empty", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new Book("Book", null));
        assertEquals("Title is null or empty", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new Book("Book", ""));
        assertEquals("Title is null or empty", ex.getMessage());
    }

    @Test
    public void testSaveBooks() throws IOException {
        Library library = new Library();

        Exception ex = assertThrows(IllegalArgumentException.class, () -> library.saveBooks(null));
        assertEquals("Path can't be null", ex.getMessage());

        Path savePath = tmp.newFile("books.txt").toPath();
        library.addBook(new Book("Author", "Title1"));
        library.addBook(new Book("Author", "Title2"));
        library.addBook(new Book("Another author", "Title1"));
        System.out.println(savePath);

        library.saveBooks(savePath);
        assertEquals(3, Files.readAllLines(savePath).size());
        assertEquals("Author;Title2", Files.readAllLines(savePath).get(1));
    }

    @Test
    public void testLoadBooks() throws IOException {
        Library library = new Library();

        Exception ex = assertThrows(IllegalArgumentException.class, () -> library.saveBooks(null));
        assertEquals("Path can't be null", ex.getMessage());

        Path loadPath = tmp.newFile("books.txt").toPath();
        Files.writeString(loadPath, "Author;Title1\n" +
                "Author;Title1\n" +
                "Author;Title2\n" +
                "Another author;Title1\n", StandardOpenOption.CREATE);

        library.loadBooks(loadPath);

        assertEquals(3, library.getBooks().size());
        assertEquals("Author;Title2", library.getBooks().get(1).toString());
    }
}
