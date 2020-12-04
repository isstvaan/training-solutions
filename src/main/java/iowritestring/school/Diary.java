package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Diary {
    private Path filePath;

    public Diary(String filePath) {

        if (filePath == null || filePath.isBlank()) {
            throw new IllegalStateException("Filepath can't be empty.");
        }
        this.filePath = Path.of(filePath);
    }

    public void newMark(String name, int grade) {
        if (name == null || name.isBlank()) {
            throw new IllegalStateException("Name can't be empty.");
        }
        if (grade < 1 || grade > 5) {
            throw new IllegalStateException("Invalid grade.");
        }

        try {
            Files.writeString(filePath, name + ":" + grade + "\n", Files.exists(filePath) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            throw new IllegalStateException("Invalid filename.");
        }
    }

    public void average() {
        try {
            List<String> lines = Files.readAllLines(filePath);
            int gradesSum = 0;
            for (String line : lines) {
                gradesSum += getGrade(line);
            }
            Files.writeString(filePath, "average: " + (double) gradesSum / lines.size() + "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalStateException(filePath.toString() + "File not found.");
        }
    }

    private int getGrade(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalStateException("Parameter can't be null");
        }
        String[] splitStr = str.split(":");
        if (splitStr.length < 2) {
            throw new IllegalStateException("Invalid string format");
        }
        try {
            return Integer.parseInt(splitStr[1]);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
