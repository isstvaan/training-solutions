package stringbasic;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringBasicTest {
    @Test
    public void sameStringsInPoolShouldBeTheSameObject() {
        //Given
        StringBasic sc = new StringBasic();

        //Then
        assertTrue(sc.createStringForPool() == sc.createStringForPool());
        assertFalse(sc.createStringForHeap() == sc.createStringForHeap());
        assertTrue(sc.createStringForPool().equals(sc.createStringForHeap()));
    }

    @Test
    public void sameStringsShouldBeTheSameByCanonicalRepresentation() {
        //Given
        StringBasic sc = new StringBasic();

        //Then
        assertTrue(sc.createStringForHeap().intern() == sc.createStringForHeap().intern());
        assertTrue(sc.createStringForHeap().intern() == sc.createStringForPool().intern());
    }
}
