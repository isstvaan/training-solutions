package week07d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTest {
    @Test
    void testDateOF() {
        Date date = Date.of(2020, 12, 9);
        assertEquals(2020, date.getYear());
        assertEquals(12, date.getMonth());
        assertEquals(9, date.getDay());

    }

    @Test
    void testWith() {
        Date date = Date.of(2020, 12, 9);
        Date dateYear = date.withYear(2000);
        assertEquals(2000, dateYear.getYear());

        Date dateMonth = date.withMonth(11);
        assertEquals(11, dateMonth.getMonth());

        Date dateDay = date.withDay(8);
        assertEquals(8, dateDay.getDay());
    }


}