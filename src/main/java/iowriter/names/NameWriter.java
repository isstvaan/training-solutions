package iowriter.names;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NameWriter {
    private Path filePath;

    public NameWriter(Path filePath) {
        if (filePath == null) {
            throw new IllegalArgumentException("filePath can't be null.");
        }
        this.filePath = filePath;
    }

    public void addAndWrite(String name) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath,
                Files.exists(filePath) ?
                        StandardOpenOption.APPEND :
                        StandardOpenOption.CREATE_NEW)) {
            bufferedWriter.write(name);
            bufferedWriter.newLine();
        } catch (IOException ex) {
            throw new IllegalStateException("File write error");
        }
    }
}
