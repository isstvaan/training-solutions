package week06d03;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SeriesTest {

    @Test
    public void testCalculateSeriesTypeThrows() throws IllegalArgumentException {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Series().calculateSeriesType(null));
        assertEquals("Numbers is null or to short.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Series().calculateSeriesType(Arrays.asList(1)));
        assertEquals("Numbers is null or to short.", exception.getMessage());
    }

    @Test
    public void testCalculateSeriesTypeGrowing() {
        //GIVEN
        List<Integer> numbers = Arrays.asList(1, 3, 5, 6, 8, 9);
        assertEquals(SeriesTypeEnum.GROVING, new Series().calculateSeriesType(numbers));
    }

    @Test
    public void testCalculateSeriesTypeDecresing() {
        //GIVEN
        List<Integer> numbers = Arrays.asList(9, 8, 6, 3, 1);
        assertEquals(SeriesTypeEnum.DECREASING, new Series().calculateSeriesType(numbers));
    }

    @Test
    public void testCalculateSeriesTypeRandom() {
        //GIVEN
        List<Integer> numbers = Arrays.asList(4, 28, 9, 1, 7);
        assertEquals(SeriesTypeEnum.RANDOM, new Series().calculateSeriesType(numbers));
    }
}
