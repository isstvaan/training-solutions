package week06d4;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemTest {

    @Test
    public void testCostructor() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Item(null, 0));
        assertEquals("Name can't be null or empty", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new Item("", 0));
        assertEquals("Name can't be null or empty", ex.getMessage());
    }

    public void testAttributes() {
        assertEquals("Test item", new Item("Test item", 0).getName());
        assertEquals(0, new Item("Test item", 0).getQuantity());

        Item item = new Item("Test item", 0);
        item.addQuantity(3);
        item.addQuantity(7);
        assertEquals(10, item.getQuantity());

    }
}
