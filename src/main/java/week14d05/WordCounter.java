package week14d05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class WordCounter {

    public long countName(String name, String filePath) {
        try (Stream<String> fileLines = Files.lines(Path.of(filePath), StandardCharsets.UTF_8)) {
            return
                    fileLines.filter(o -> o.toUpperCase().contains(name.toUpperCase()))
                            .flatMap(WordCounter::lineToword)
                            .filter(o -> o.toUpperCase().contains(name.toUpperCase()))
                            .count();
        } catch (IOException e) {
            throw new IllegalStateException("File read error", e);
        }
    }

    private static Stream<? extends String> lineToword(String line) {
        return Arrays.stream(line.split(" "));
    }

    public static void main(String[] args) {
        System.out.println(new WordCounter().countName("Hach", "hachiko.srt"));
    }
}
