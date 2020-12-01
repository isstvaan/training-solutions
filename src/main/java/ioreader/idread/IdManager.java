package ioreader.idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {
    private List<String> ids = new ArrayList<>();

    public void readIdsFromFile(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("File name can't be empty");
        }

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/main/resources/" + fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                ids.add(line);
            }

        } catch (IOException e) {
            throw new IllegalStateException("File read error.", e);
        }
    }

    public List<String> getIds() {
        return new ArrayList<>(ids);
    }
}
