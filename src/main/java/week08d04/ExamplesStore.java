package week08d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExamplesStore {
    private static final String FILE_NAME = "examples.md";

    public static List<String> getTitlesOfExamples() {
        List<String> titles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ExamplesStore.class.getResourceAsStream(FILE_NAME)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    titles.add(line.replace("# ", ""));
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("File read error.",e);
        }
        return titles;
    }

    public static void main(String[] args) {
        System.out.println( ExamplesStore.getTitlesOfExamples());
    }
}
