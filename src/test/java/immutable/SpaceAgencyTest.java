package immutable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpaceAgencyTest {

    @Test
    private void testRegisterSatelliteNUllException() throws IllegalArgumentException {
        SpaceAgency spaceAgency = new SpaceAgency();

        Exception ex = assertThrows(IllegalArgumentException.class, () -> spaceAgency.registerSatellite(null));
        assertEquals(IllegalArgumentException.class, ex.getClass());
    }

    @Test
    private void testRegisterSatellite() {
        SpaceAgency spaceAgency = new SpaceAgency();
        spaceAgency.registerSatellite(new Satellite(new CelestialCoordinates(1, 2, 3), "123456789"));

        assertEquals("123456789",spaceAgency.toString());
    }

    @Test
    private void testFindSatelliteByRegisterIdent() {
        Satellite satellite = new Satellite(new CelestialCoordinates(1, 2, 3), "987654321");
        SpaceAgency spaceAgency = new SpaceAgency();

        assertEquals("987654321", spaceAgency.findSatelliteByRegisterIdent("987654321"));
    }

    @Test
    private void testFindSatelliteByRegisterIdentNotFound() {
        Satellite satellite = new Satellite(new CelestialCoordinates(1, 2, 3), "987654321");
        SpaceAgency spaceAgency = new SpaceAgency();

        assertEquals("XYZ satelite not registered!", spaceAgency.findSatelliteByRegisterIdent("XYZ"));
    }
}
