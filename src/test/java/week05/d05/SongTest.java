package week05.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SongTest {
    @Test
    public void testConstructorTrows() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Song(null, 0, null));
        assertEquals("Name can't be empty.", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new Song("Test", 1, null));
        assertEquals("Artist can't be empty.", ex.getMessage());

        ex = assertThrows(IllegalStateException.class, () -> new Song("Test", 0, "Test"));
        assertEquals("Invalid length", ex.getMessage());

    }
}
