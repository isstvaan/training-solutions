package collectionsautoboxing;

import java.util.*;

public class IntegerOperations {
    public List<Integer> createList(int... numbers) {
        List<Integer> result = new ArrayList<>();
        for (int i : numbers) {
            result.add(i);
        }
        return result;
    }

    public int sumIntegerList(List<Integer> integerList) {
        int result = 0;
        for (int item : integerList) {
            result += item;
        }
        return result;
    }

    public int sumIntegerObjects(Integer... integers) {
        int result = 0;
        for (int item : integers) {
            result += item;
        }
        return result;
    }
}
