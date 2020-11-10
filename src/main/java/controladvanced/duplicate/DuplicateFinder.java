package controladvanced.duplicate;

import java.util.ArrayList;
import java.util.List;

public class DuplicateFinder {
    public List<Integer> findDuplicates(List<Integer> list) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (value == list.get(j)) {
                    duplicates.add(list.get(j));
                    break;
                }
            }
        }

        return duplicates;
    }

}
