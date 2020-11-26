package week05.d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {
    @Test
    public void testConstructorThrows() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Product(-1, null));
        assertEquals("Price must be positive.", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new Product(1, null));
        assertEquals("Currency can't be null.", ex.getMessage());

    }

    @Test
    public void testConvertPrice() {

        assertEquals(1, new Product(1, Currency.USD).convertPrice(Currency.USD));
        assertEquals(300, new Product(1, Currency.USD).convertPrice(Currency.HUF));
        assertEquals(300, new Product(300, Currency.HUF).convertPrice(Currency.HUF));
        assertEquals(1, new Product(300, Currency.HUF).convertPrice(Currency.USD));
        assertEquals(.5, new Product(150, Currency.HUF).convertPrice(Currency.USD));
    }
}
