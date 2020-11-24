package week05d02;

import org.junit.jupiter.api.Test;
import week04.NameChanger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChangeLetterTest {

    @Test
    public void testThrows() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new ChangeLetter().changeVowels(null));
        assertEquals("Parameter can't be empty", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new ChangeLetter().changeVowels(""));
        assertEquals("Parameter can't be empty", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new ChangeLetter().changeVowels2(null));
        assertEquals("Parameter can't be empty", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new ChangeLetter().changeVowels2(""));
        assertEquals("Parameter can't be empty", ex.getMessage());
    }

    @Test
    public void testChangeVowels() {

        assertEquals("*rv*zt*r* t*k*rf*r*g*p", new ChangeLetter().changeVowels("arvizturo tukorfurogep"));
        assertEquals("*rv*zt*r* t*k*rf*r*g*p", new ChangeLetter().changeVowels2("arvizturo tukorfurogep"));
    }
}
