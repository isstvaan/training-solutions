package collectionsset.collectionstreeset;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class WordFilter {
    public Set<String> filterWords(String[] randomStrings) {
        return new TreeSet<>(List.of(randomStrings));
    }
}
