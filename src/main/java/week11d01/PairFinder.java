package week11d01;

import java.util.ArrayList;
import java.util.List;

public class PairFinder {
    public int findPairs(int[] arr) {
        int result = 0;
        List<Integer> numberCollector = new ArrayList<>();

        for (int item : arr) {
            if (numberCollector.contains(item)) {
                result++;
                numberCollector.remove((Integer) item);
            } else {
                numberCollector.add(item);
            }
        }

        return result;
    }
}
