package iofilestest.cheese;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CheeseManager {

    public void saveToFile(Path path, List<Cheese> cheeses) {
        if (path == null) {
            throw new IllegalArgumentException("Path is null.");
        }
        if (cheeses == null) {
            throw new IllegalArgumentException("Cheeses is null.");
        }

        try (BufferedOutputStream stream = new BufferedOutputStream(Files.newOutputStream(path))) {
            for (Cheese item : cheeses) {
                stream.write((item.toString() + "\n").getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cheese findCheese(Path path, String cheeseName) {
        if (path == null) {
            throw new IllegalArgumentException("Path is null.");
        }
        if (cheeseName == null || cheeseName.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or empty");
        }

        try {
            List<String> lines = Files.readAllLines(path);
            for (String item : lines) {
                String[] splittedStr = item.split(";");
                if (splittedStr.length > 1) {
                    if (splittedStr[0].equals(cheeseName)) {
                        return new Cheese(splittedStr[0], Double.parseDouble(splittedStr[1]));
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("File read error", e);
        }
        return null;
    }
}
