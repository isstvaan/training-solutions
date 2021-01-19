package collectionslist.collectionsarraylist;

import java.util.*;

public class Lottery {

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }

        List<Integer> numbers = new ArrayList<>();
        Random rnd = new Random();
        while (numbers.size() < lotteryType) {
            int number = 1 + rnd.nextInt(ballCount);
            if (!numbers.contains(number))
                numbers.add(number);
        }
        Collections.sort(numbers);
        return numbers;
    }
}
