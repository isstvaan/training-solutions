package week04.d02;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class SearchTest {
    @Test
    public void testCheckIndexWithResult()
    {
        assertEquals("[0, 3]",new Search().getIndexesOfChar("alma",'a').toString() );
    }

    @Test
    public void testCheckIndexWithNoResult()
    {
        assertEquals("[]",new Search().getIndexesOfChar("alma",'e').toString() );
    }


}
