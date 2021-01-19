package collectionslist.collectionslinkedlist;

import java.util.*;

public class Draw {
    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount >= maxNumber) {
            throw new IllegalArgumentException("drawCount must be less then 8!");
        }

        List<Integer> numbers = new LinkedList<>();
        Random rnd = new Random();
        while (numbers.size() < maxNumber) {
            int number = 1 + rnd.nextInt(maxNumber);
            if (!numbers.contains(number))
                numbers.add(number);
        }

        return new TreeSet<>(numbers);
    }
}
