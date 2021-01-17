package week11d04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameLengthTest {

    @Test
    void getLengths() {
        assertEquals("[3, 4]", new NameLength().getLengths(List.of("Joe", "Jack", "Jane", "Jake", "George", "William")).toString());
        assertEquals("[3, 4, 6]", new NameLength().getLengths(List.of("Joe", "Jack", "Jane", "Jake", "George", "William", "Joseph")).toString());
        assertEquals("[4, 3, 8]", new NameLength().getLengths(List.of("Jack", "Joe", "Jane", "Jake", "George", "William", "Jeremiah", "Jim", "Jonathan")).toString());
    }
}