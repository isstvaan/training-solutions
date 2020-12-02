package week06d03;

import java.util.List;

public class Series {

    public SeriesTypeEnum calculateSeriesType(List<Integer> numbers) {
        if (numbers == null || numbers.size() < 2) {
            throw new IllegalArgumentException("Numbers is null or to short.");
        }

        boolean isGroving = true;
        boolean isDecreasing = true;
        int prevValue = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            isGroving = isGroving && prevValue < numbers.get(i);
            isDecreasing = isDecreasing && prevValue > numbers.get(i);
        }

        return isGroving ? SeriesTypeEnum.GROVING :
                isDecreasing ? SeriesTypeEnum.DECREASING :
                        SeriesTypeEnum.RANDOM;
    }
}
