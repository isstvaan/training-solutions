package week06d01;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SeparatedSumTest {

    @Test
    public void testNullEmptyParameters() throws IllegalStateException {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new SeparatedSum().sum(null));
        assertEquals("String can't be empty.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new SeparatedSum().sum(null));
        assertEquals("String can't be empty.", exception.getMessage());
    }

    @Test
    public void testWrongInputParameters() throws IllegalStateException {
        Exception exception = assertThrows(IllegalStateException.class, () -> new SeparatedSum().sum("1;2,3;c;5"));
        assertEquals("Wrong number format", exception.getMessage());
    }

    @Test
    public void testSeparatedSum() {
        assertEquals(new PositiveNegativeNumbers(5, -5).toString(), new SeparatedSum().sum("1,1;3,9;-1.9;-3.1;0").toString());
    }
}
