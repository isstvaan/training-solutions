package stringscanner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringScannerTest {

    @Test(expected = IllegalArgumentException.class)
    public void incorrectParameterShouldThrowException() throws IllegalArgumentException {
        new StringScanner().readAndSumValues("a:2:4", ":");
    }


    @Test(expected = IllegalArgumentException.class)
    public void parameterIsNullShouldThrowException() throws IllegalArgumentException {

        new StringScanner().readAndSumValues("3:2:4", null);
        //assertEquals("Incorrect parameter string!", ex.getMessage());
    }

    @Test
    public void delimiterIsSpaceOrNull() {

        assertEquals(11, new StringScanner().readAndSumValues("2 4 5", " "));
        assertEquals(11, new StringScanner().readAndSumValues("2 4 5", null));
    }


    @Test
    public void readAndSumValues() {

        assertEquals(6, new StringScanner().readAndSumValues("1:2:3", ":"));
        assertEquals(6, new StringScanner().readAndSumValues("1:2:3", ":"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void readAndSumValuesWithoutDelimiter() {
        assertEquals(6, new StringScanner().readAndSumValues("1 2 3"));

        new StringScanner().readAndSumValues("3:2:4", null);
    }

    @Test
    public void filterLinesWithWordOccurrences() {
        assertEquals("first word\nnext word", new StringScanner().filterLinesWithWordOccurrences("first word\napple\nnext word", "word"));
        assertEquals("", new StringScanner().filterLinesWithWordOccurrences("first\napple\nnext", "word"));
        assertEquals("", new StringScanner().filterLinesWithWordOccurrences("first\napple\nnext", " "));
    }

    @Test(expected = IllegalArgumentException.class)
    public void textIsEmptyShouldThrowException() throws IllegalArgumentException {
        new StringScanner().filterLinesWithWordOccurrences("", "word");
    }

    @Test(expected = IllegalArgumentException.class)
    public void textIsJustSpacesShouldThrowException() throws IllegalArgumentException {
        new StringScanner().filterLinesWithWordOccurrences("       ", "word");
    }

    @Test(expected = IllegalArgumentException.class)
    public void textIsNullShouldThrowException() throws IllegalArgumentException {
        new StringScanner().filterLinesWithWordOccurrences(null, "word");
    }

    @Test(expected = IllegalArgumentException.class)
    public void wordIsNullShouldThrowException() throws IllegalArgumentException {
        new StringScanner().filterLinesWithWordOccurrences("a\nbc", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wordIsEmptyShouldThrowException() throws IllegalArgumentException {
        new StringScanner().filterLinesWithWordOccurrences("a\nbc", "");
    }
}
