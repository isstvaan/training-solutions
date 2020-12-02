package ioprintwriter.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SalaryWriter {
    private List<String> names;

    public SalaryWriter(List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("names can't be null");
        }

        this.names = names;
    }

    public void writeNamesAndSalaries(Path file) {
        if (file == null) {
            throw new IllegalArgumentException("file can't be null");
        }

        try (PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(file))) {

            for (String item : names) {
                if (item.startsWith("Dr")) {
                    printWriter.println(item + ": 500000");
                } else if (item.startsWith("Mr")) {
                    printWriter.println(item + ": 200000");
                } else {
                    printWriter.println(item + ": 100000");
                }
            }

        } catch (IOException ex) {
            throw new IllegalStateException("File write error");
        }
    }
}
