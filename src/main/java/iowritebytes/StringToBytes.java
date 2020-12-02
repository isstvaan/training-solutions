package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StringToBytes {

    public void writeAsBytes(List<String> words, Path path) {
        if (words == null) {
            throw new IllegalArgumentException("Words can't be null");
        }
        if (path == null) {
            throw new IllegalArgumentException("Path can't be null");
        }

        try (OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(path))) {
            for (String item : words) {
                if(!item.startsWith("_"))
                {
                    outputStream.write(item.getBytes());
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
    }
}
