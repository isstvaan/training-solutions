package week11d04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameLength {
    private static final String NAME_PREFIX = "J";

    public List<Integer> getLengths(List<String> names) {
        List<Integer> jStartNamesLengths = new ArrayList<>();
        for (String item : names) {
            if (item.toUpperCase().startsWith(NAME_PREFIX) && !jStartNamesLengths.contains((Integer) item.length())) {
                jStartNamesLengths.add((Integer) item.length());
            }
        }
        return jStartNamesLengths;
    }

    public List<Integer> getLengths2(List<String> names) {
        Set<Integer> jStartNamesLengths = new HashSet<>();
        if (names != null) {
            for (String item : names) {
                if (item.toUpperCase().startsWith(NAME_PREFIX)) {
                    jStartNamesLengths.add((Integer) item.length());
                }
            }
        }
        return new ArrayList<>(jStartNamesLengths);
    }

}
