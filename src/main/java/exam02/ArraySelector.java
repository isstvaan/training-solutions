package exam02;

import java.util.ArrayList;
import java.util.List;

public class ArraySelector {
    public String selectEvens(int[] array) {
        if (array.length == 0) {
            return "";
        }
        List<Integer> events = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                events.add(array[i]);
            }
        }
        return events.toString();
    }
}
