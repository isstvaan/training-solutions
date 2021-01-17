package week11d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {

    @Test
    void testCountChars() {
        assertEquals(1, new CharCounter().countChars(new String[]{"abc", "cbf", "ab"}));
        assertEquals(2, new CharCounter().countChars(new String[]{"abc", "cba", "ab"}));
        assertEquals(3, new CharCounter().countChars(new String[]{"abc", "cba", "acb"}));
        assertEquals(4, new CharCounter().countChars(new String[]{"abcw", "cbaew", "abcdwerrt"}));
    }
}