package immutable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CelestialCoordinatesTest {
    @Test
    private void testCelestialCoordinates() {
        assertEquals("CelestialCoordinates{x=1, y=2, z=4}", new CelestialCoordinates(1, 2, 3).toString());
    }

}
