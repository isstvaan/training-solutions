package exampractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperSoftwareTest {

    @Test
    void testIncreasePrice() {
        DeveloperSoftware software = new DeveloperSoftware("Test", 100);
        software.increasePrice();
        assertEquals(110, software.getPrice(),0.1);
        software.increasePrice();
        assertEquals(121, software.getPrice(),0.1);
    }
}