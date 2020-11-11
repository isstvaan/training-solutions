package algorithmsmax;

import java.util.List;

public class IntegerMaxCalculator {
    public int getMax(List<Integer> integers) {
        int maxVal = Integer.MIN_VALUE;
        for (Integer item : integers) {
            maxVal = maxVal < item ? item : maxVal;
        }
        return maxVal;
    }
}
