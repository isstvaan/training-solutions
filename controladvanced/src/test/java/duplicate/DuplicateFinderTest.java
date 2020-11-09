package duplicate;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DuplicateFinderTest {
    @Test
    public void findDuplicates() {
        assertEquals(Arrays.asList(), new DuplicateFinder().findDuplicates(Arrays.asList()));
        assertEquals(Arrays.asList(), new DuplicateFinder().findDuplicates(Arrays.asList(1, 2, 3)));
        assertEquals(Arrays.asList(2), new DuplicateFinder().findDuplicates(Arrays.asList(1, 2, 2, 3)));
        assertEquals(Arrays.asList(2, 3), new DuplicateFinder().findDuplicates(Arrays.asList(1, 2, 2, 3, 3, 4)));
        assertEquals(Arrays.asList(3, 3), new DuplicateFinder().findDuplicates(Arrays.asList(1, 2, 3, 3, 3, 4)));
        assertEquals(Arrays.asList(2, 3, 3), new DuplicateFinder().findDuplicates(Arrays.asList(1, 2, 2, 3, 3, 3, 4)));

    }
}
