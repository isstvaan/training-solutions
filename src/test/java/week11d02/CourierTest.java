package week11d02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {
    static Courier courier = new Courier();

    @BeforeAll
    static void initTest() {
        courier = new Courier();
        courier.readRidesFile(Courier.class.getResourceAsStream("rides.txt"));
    }

    @Test
    void testGetHolidays() {
        assertEquals(new int[]{6, 7}[0], courier.getHolidays().get(0));
        assertEquals(new int[]{6, 7}[1], courier.getHolidays().get(1));
    }

    @Test
    void testGetDistanceOfDay() {
        assertEquals(new int[]{68, 12, 24, 12, 24, 0, 0}[3], courier.getDistanceOfDay()[3]);
    }

    @Test
    void testGetFirstRide() {
        assertEquals(new Ride(1, 1, 10), courier.getFirstRide());
    }

    @Test
    void testGetLastRide() {
        assertEquals(new Ride(5, 3, 24), courier.getLastRide());
    }
}