package week04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameChangerTest {
    @Test
    public void testContructor() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new NameChanger(null));
        assertEquals("Name can't be empty.", ex.getMessage());
    }

    @Test
    public void testchangeFirstName() {

        NameChanger nameChanger=    new NameChanger("Kiss János");
        nameChanger.changeFirstName("Nagy");
        assertEquals("Nagy János", nameChanger.getFullName());
    }
}
