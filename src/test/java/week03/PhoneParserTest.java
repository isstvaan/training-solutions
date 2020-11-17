package week03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhoneParserTest {
    @Test
    void phoneParseTestNull() throws IllegalArgumentException
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new PhoneParser().parsePhone(null));
        assertEquals(IllegalArgumentException.class, ex.getClass());
    }

    @Test
    void phoneParseTestWrongInput() throws IllegalArgumentException
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new PhoneParser().parsePhone("12334567878"));
        assertEquals(IllegalArgumentException.class, ex.getClass());
    }

    @Test
    void phoneParseTest()
    {
        assertEquals("Phone: 12/34567890",  new PhoneParser().parsePhone("12+34567890").toString());
    }
}
