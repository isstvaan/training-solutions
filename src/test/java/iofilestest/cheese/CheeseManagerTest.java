package iofilestest.cheese;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheeseManagerTest {
    @Rule
    public TemporaryFolder tmp = new TemporaryFolder();

    @Test
    public void testSaveToFileThrows() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new CheeseManager().saveToFile(null, null));
        assertEquals("Path is null.", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new CheeseManager().saveToFile(tmp.newFile().toPath(), null));
        assertEquals("Cheeses is null.", ex.getMessage());
    }

    @Test
    public void testSaveToFile() throws IOException {
        Path testFile = tmp.newFile("cheeses.txt").toPath();
        List<Cheese> cheesesTest = new ArrayList<>();
        cheesesTest.add(new Cheese("Cheese1", 1));
        cheesesTest.add(new Cheese("Cheese2", 2));
        cheesesTest.add(new Cheese("Cheese3", 3));
        cheesesTest.add(new Cheese("Cheese4", 4));

        new CheeseManager().saveToFile(testFile, cheesesTest);

        List<String> lines = Files.readAllLines(testFile);
        assertEquals(4, lines.size());
        assertEquals("Cheese2;2.0", lines.get(1).toString());
    }

    @Test
    public void testFindCheese() throws IOException {
        Path testFile = tmp.newFile("cheeses.txt").toPath();
        Files.writeString(testFile, "Cheese1;1.0\n" +
                "Cheese2;2.0\n" +
                "Cheese3;3.0\n" +
                "Cheese4;4.0\n", StandardOpenOption.CREATE);

        assertEquals("Cheese3;3.0", new CheeseManager().findCheese(testFile, "Cheese3").toString());
        assertEquals(null, new CheeseManager().findCheese(testFile, "Cheese5"));
    }

}
