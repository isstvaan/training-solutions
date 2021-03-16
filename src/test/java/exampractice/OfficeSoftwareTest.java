package exampractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficeSoftwareTest {

    @Test
    void testIncreasePrice() {
        OfficeSoftware software = new OfficeSoftware("Test", 100);
        software.increasePrice();
        assertEquals(105, software.getPrice(),0.1);
        software.increasePrice();
        assertEquals(110.25, software.getPrice(),0.1);
    }
}