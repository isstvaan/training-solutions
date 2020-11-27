package iowritestring.school;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiaryTest {
    Path filePath;
    Path filePathError;

    @BeforeEach
    private void initPaths() {
        filePath = Path.of("src", "test", "resources", "tanulo_neve.txt");
        filePathError = Path.of("src", "testError", "resources", "tanulo_neve.txt");
    }

    @Test
    public void testConstructorTrows() throws IllegalStateException {

        Exception ex = assertThrows(IllegalStateException.class, () -> new Diary(null));
        assertEquals("Filepath can't be empty.", ex.getMessage());

        ex = assertThrows(IllegalStateException.class, () -> new Diary(""));
        assertEquals("Filepath can't be empty.", ex.getMessage());
    }

    @Test
    public void testNewMarkTrows() throws IllegalStateException {

        Exception ex = assertThrows(IllegalStateException.class, () -> new Diary(filePath.toString()).newMark(null, 0));
        assertEquals("Name can't be empty.", ex.getMessage());

        ex = assertThrows(IllegalStateException.class, () -> new Diary(filePath.toString()).newMark("", 0));
        assertEquals("Name can't be empty.", ex.getMessage());

        ex = assertThrows(IllegalStateException.class, () -> new Diary(filePath.toString()).newMark("Teszt Elek", 0));
        assertEquals("Invalid grade.", ex.getMessage());

        ex = assertThrows(IllegalStateException.class, () -> new Diary(filePath.toString()).newMark("Teszt Elek", 6));
        assertEquals("Invalid grade.", ex.getMessage());

        ex = assertThrows(IllegalStateException.class, () -> new Diary(filePathError.toString()).newMark("Teszt Elek", 5));
        assertEquals("Invalid filename.", ex.getMessage());
    }

    @Test
    public void testNewMark() throws IOException {

        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Diary diary = new Diary(filePath.toString());
        diary.newMark("Teszt Elek", 5);
        diary.newMark("Lapos Elemér", 2);

        assertEquals("Teszt Elek:5\nLapos Elemér:2\n", Files.readString(filePath));
    }

    @Test
    public void testAverage() throws IOException {
        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Diary diary = new Diary(filePath.toString());
        diary.newMark("Teszt Elek", 5);
        diary.newMark("Lapos Elemér", 2);
        diary.average();
        assertEquals("Teszt Elek:5\nLapos Elemér:2\n3.5\n", Files.readString(filePath));
    }
}
