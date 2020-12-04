package week06d05;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BottleTest {

    @Test
    public void testConstructorNull() throws IllegalArgumentException {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Bottle(null));
        assertEquals("Type can't be null", exception.getMessage());
    }

    @Test
    public void testStaticOf() {
        assertEquals(BottleType.GLASS_BOTTLE, Bottle.of(BottleType.GLASS_BOTTLE).getType());
        assertEquals(BottleType.PET_BOTTLE, Bottle.of(BottleType.PET_BOTTLE).getType());
    }

    @Test
    public void testFill() throws IllegalStateException {
        Bottle bottle = Bottle.of(BottleType.PET_BOTTLE);
        bottle.fill(300);
        assertEquals(300, bottle.getFilledUntil());

        bottle.fill(200);
        assertEquals(BottleType.PET_BOTTLE.getMaximumAmount(), bottle.getFilledUntil());

        Exception exception = assertThrows(IllegalStateException.class, () -> bottle.fill(1));
        assertEquals("Bottle overfilled.", exception.getMessage());
    }
}
