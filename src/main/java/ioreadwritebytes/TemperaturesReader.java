package ioreadwritebytes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

    public Temperatures readTemperatures(String path) {
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("Path can't be emtpy");
        }
        try {
            byte[] datas = Files.readAllBytes(Path.of(path));
            return new Temperatures(datas);
        } catch (IOException e) {
            throw new IllegalStateException("File read error.", e);
        }
    }
}
