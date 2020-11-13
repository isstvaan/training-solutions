package immutable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SatelliteTest {
    @Test
    public void emptyParameterShouldThrowException() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Satellite(new CelestialCoordinates(1, 2, 3), ""));
        assertEquals("registerIdent parameter must not be null.", ex.getMessage());

        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> new Satellite(null, ""));
        assertEquals("destinationCoordinates parameter must not be null.", ex1.getMessage());

        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> new Satellite(null, null));
        assertEquals("destinationCoordinates parameter must not be null.", ex2.getMessage());

    }

    @Test
    public void testModifyDestination() {
        // Given
        Satellite satellite = new Satellite(new CelestialCoordinates(12, 23, 45), "ASD567");
        // When
        satellite.modifyDestination(new CelestialCoordinates(2, 2, 2));
        //Then
        assertEquals("ASD567: CelestialCoordinates{x=14, y=25, z=47}", satellite.toString());
    }
}
