package week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void findPairsTest() {
        assertEquals(1, new PairFinder().findPairs(new int[]{1, 2, 3, 3, 3, 4, 5}));
        assertEquals(2, new PairFinder().findPairs(new int[]{1, 2, 3, 3, 3, 4, 5, 2}));
        assertEquals(3, new PairFinder().findPairs(new int[]{1, 2, 3, 3, 3, 4, 5, 2, 5}));
        assertEquals(4, new PairFinder().findPairs(new int[]{1, 2, 3, 3, 3, 4, 5, 1, 2, 3}));
    }
}