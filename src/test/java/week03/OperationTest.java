package week03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperationTest {
    @Test
    void operationTestNull() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Operation(null));
        assertEquals(IllegalArgumentException.class, ex.getClass());
    }

    @Test
    void operationTestWrongInput() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Operation("12334567878"));
        assertEquals(IllegalArgumentException.class, ex.getClass());
    }

    @Test
    void operationTest(){
        assertEquals(55,  new Operation("12+43").getResult());
    }
}
