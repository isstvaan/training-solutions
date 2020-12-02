package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {

    public void makeImageFile(byte[][] imageRaw, Path filePath) {
        if (imageRaw == null) {
            throw new IllegalArgumentException("Image raw can't be null");
        }
        if (filePath == null) {
            throw new IllegalArgumentException("FilePath can't be null");
        }

        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(filePath))) {
            for (byte[] item : imageRaw) {
                bufferedOutputStream.write(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
