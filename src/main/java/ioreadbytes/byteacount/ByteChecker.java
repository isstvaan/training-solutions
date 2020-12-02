package ioreadbytes.byteacount;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {

    public int readBytesAndFindAs(String filePath) {
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("filepath can't be empty");
        }

        Path path = Path.of("src/test/resources/" + filePath);
        if (Files.exists(path)) {
            System.out.println("");
        }
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(path))) {
            byte[] readBuffer = new byte[100];
            int counts = 0;
            int readedBytes = 0;
            while ((readedBytes = bufferedInputStream.read(readBuffer)) > 0) {
                for (int i = 0; i < readedBytes; i++) {
                    if (readBuffer[i] == 'a') {
                        counts++;
                    }
                }
            }
            return counts;
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file.", e);
        }
    }
}
