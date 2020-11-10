package controliteration;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class PITest {
    @Test
    public void getPi() {
        assertEquals("3,141592653589793238462643383279", new PIValue().getPIValue());
    }
}
