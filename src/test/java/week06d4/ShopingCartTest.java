package week06d4;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShopingCartTest {

    @Test
    public void testThrows() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new ShoppingCart().addItem(null, 0));
        assertEquals("Name can't be null or empty", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new ShoppingCart().addItem("", 0));
        assertEquals("Name can't be null or empty", ex.getMessage());
    }

    @Test
    public void testAddItem() throws IllegalArgumentException {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem("Item1", 1);
        shoppingCart.addItem("Item2", 1);
        shoppingCart.addItem("Item3", 1);
        shoppingCart.addItem("Item4", 10);
        shoppingCart.addItem("Item1", 9);
        shoppingCart.addItem("Item2", 4);

        assertEquals(10, shoppingCart.getItem("Item1"));
        assertEquals(5, shoppingCart.getItem("Item2"));
        assertEquals(1, shoppingCart.getItem("Item3"));
        assertEquals(10, shoppingCart.getItem("Item4"));

    }
}
