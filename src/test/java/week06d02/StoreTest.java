package week06d02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StoreTest {
    @Test
    public void testNullParameter() throws IllegalStateException {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Store(null));
        assertEquals("Products can't be null", exception.getMessage());
    }

    @Test
    public void testGetProductsByCategory() {
        //GIVEN
        List<Product> testProducts = new ArrayList<>();
        testProducts.add(new Product("Test1", ProductCategory.BAKEDGOODS, 100));
        testProducts.add(new Product("Test2", ProductCategory.DAIRY, 100));
        testProducts.add(new Product("Test3", ProductCategory.FROZEN, 100));
        testProducts.add(new Product("Test4", ProductCategory.OTHER, 100));
        testProducts.add(new Product("Test5", ProductCategory.BAKEDGOODS, 200));
        testProducts.add(new Product("Test6", ProductCategory.DAIRY, 200));
        testProducts.add(new Product("Test7", ProductCategory.DAIRY, 200));
        testProducts.add(new Product("Test8", ProductCategory.OTHER, 200));
        testProducts.add(new Product("Test9", ProductCategory.OTHER, 200));

        assertEquals("[BAKEDGOODS: 2, DAIRY: 3, FROZEN: 1, OTHER: 3]", new Store(testProducts).getProductsByCategory().toString());

    }
}
