package week15d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ConsonantCounter {
    private final List<Character> consonants = getConsonants();
    Stream<String> lines;

    public ConsonantCounter(String filePath) {
        try {
            lines = Files.lines(Path.of(filePath));
        } catch (IOException e) {
            throw new IllegalStateException("File read error");
        }
    }

    private List<Character> getConsonants() {
        List<Character> consonatsList = new ArrayList<>();
        for (int i = 65; i <= 90; i++) {
            consonatsList.add((char) i);
        }

        return consonatsList;
    }

    private long getConsonantsCount(String str) {
        long count = lines.map(s -> s.replace(" ", "").toUpperCase().toCharArray())
                .mapToInt(this::getNumberOfConsonants)
                .summaryStatistics()
                .getSum();
        return count;
    }

    private int getNumberOfConsonants(char[] chars) {
        int retVal = 0;
        for (char item : chars) {
            if (consonants.contains(item)) {
                retVal++;
            }
        }
        return retVal;
    }

    public static void main(String[] args) {
        ConsonantCounter consonantCounter = new ConsonantCounter("test.txt");
//        ConsonantCounter consonantCounter = new ConsonantCounter("templateReplaced.txt");
        System.out.println(consonantCounter.getConsonantsCount(""));
    }


}
