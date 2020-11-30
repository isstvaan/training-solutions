package ioreadwritebytes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesWriter {
    public void writeTemperatures(Temperatures temperatures, String path) {
        if (temperatures == null) {
            throw new IllegalArgumentException("Temperaturen can't be null");
        }
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("Path can't be emtpy");
        }

        try {
            Files.write(Path.of(path), temperatures.getData());
        } catch (IOException e) {
            throw new IllegalStateException("File write error.", e);
        }
    }
}
