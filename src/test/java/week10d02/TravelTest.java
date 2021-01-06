package week10d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelTest {

    @Test
    void getStopWithMax() {
        assertEquals(20, new Travel().getStopWithMax(Travel.class.getResourceAsStream("utasadat.txt")));
    }

    @Test
    void fillListWithNumbers() {
        int[] numbers = new Travel().fillListWithNumbers(Travel.class.getResourceAsStream("utasadat.txt"));
        assertEquals(4, numbers[0]);
        assertEquals(0, numbers[1]);
        assertEquals(5, numbers[20]);
        assertEquals(0, numbers[29]);
    }

    @Test
    void getMaxValueIndex() {
        int[] tmp = new int[10];
        tmp[2] = 10;
        tmp[4] = 20;
        assertEquals(4, new Travel().getMaxValueIndex(tmp));
    }
}