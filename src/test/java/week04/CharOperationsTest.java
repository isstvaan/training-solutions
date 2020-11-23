package week04;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CharOperationsTest {
    @Test
    public void testCheckIndexWithResult()
    {
        assertEquals("[0, 3]",new CharOperations().getIndexesOfChar("alma",'a').toString() );
    }

    @Test
    public void testCheckIndexWithNoResult()
    {
        assertEquals("[]",new CharOperations().getIndexesOfChar("alma",'e').toString() );
    }


}
