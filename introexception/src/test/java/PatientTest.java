import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PatientTest {

    @Test
    public void validSsn() {
        Patient patient = new Patient("John Doe", "123456788", 2000);
        assertEquals("John Doe", patient.getName());
        assertEquals("123456788", patient.getSocialSecurityNumber());
        assertEquals(2000, patient.getYearOfBirth());
    }
}
