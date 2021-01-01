package week08d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ExamplesStore {
    private static final String FILE_NAME = "examples.md";

    public static List<String> getTitlesOfExamples() {
        List<String> titles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(Files.newBufferedReader(Path.of(FILE_NAME)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    titles.add(line.replace("# ", ""));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return titles;
    }

    public static void main(String[] args) {
        System.out.println( ExamplesStore.getTitlesOfExamples());
    }
}
