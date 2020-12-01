package week06d02;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {
    @Test
    public void testNullEmptyParameters() throws IllegalStateException {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Product(null,null,0));
        assertEquals("Name can't be empty", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Product("",null,0));
        assertEquals("Name can't be empty", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Product("Tesz",null,0));
        assertEquals("Category can't be null", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Product("Teszt",ProductCategory.BAKEDGOODS,0));
        assertEquals("Price must be positive number", exception.getMessage());

    }
}
