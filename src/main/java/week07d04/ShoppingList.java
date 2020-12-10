package week07d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ShoppingList {
    public long calculateSum(String path) {
        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            long sum = 0;

            for (String line : lines) {
                sum += getValueFromString(line);
            }
            return sum;
        } catch (IOException ex) {
            throw new IllegalStateException("File not found", ex);
        }
    }

    private long getValueFromString(String str) {
        try {
            String[] splittedStr = str.split(";");
            return Long.parseLong(splittedStr[1]) * Long.parseLong(splittedStr[2]);
        } catch (NumberFormatException ex) {
            throw new IllegalStateException("Invalid string format");
        }
    }
}
