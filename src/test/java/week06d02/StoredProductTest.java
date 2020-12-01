package week06d02;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StoredProductTest {
    @Test
    public void testNullParameter() throws IllegalStateException {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new StoredProduct(null,0));
        assertEquals("Category can't be null", exception.getMessage());
    }
}
