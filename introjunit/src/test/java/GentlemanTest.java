import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GentlemanTest {
    @Test
    public void testSayHello() {
        //Given
        Gentleman gentleman = new Gentleman();

        //When
        String welcome= gentleman.sayHello("John Doe");

        //Then
        assertEquals(welcome,"Hello John Doe");
    }

    @Test
    public void testSayHelloNULL() {
        //Given
        Gentleman gentleman = new Gentleman();

        //When
        String welcome= gentleman.sayHello(null);

        //Then
        assertEquals(welcome,"Hello Anonymous");
    }
}
