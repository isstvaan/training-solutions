package ioreadbytes.bytematrix;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MatrixReader {
    List<byte[]> matrix = new ArrayList<>();

    public void readBytesAndCreateMatrix(String filepath) {
        if (filepath == null || filepath.isBlank()) {
            throw new IllegalArgumentException("File path can't be empty");
        }

        Path path = Path.of(filepath);
        try (InputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(path))) {
            int readedBytes = 0;
            byte[] buffer = new byte[1000];
            while ((readedBytes = bufferedInputStream.read(buffer)) > 0) {
                if (readedBytes == buffer.length) {
                    matrix.add(buffer);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file");
        }
    }

    public int numberOfColumnsWhereMoreZeros() {
        int columnsCount = 0;
        for (byte[] item : matrix) {
            int zeros = 0;
            for (int i = 0; i < item.length; i++) {
                if (item[i] == '0') {
                    zeros++;
                }
            }
            if (zeros > item.length / 2.0) {
                columnsCount++;
            }
        }
        return columnsCount;
    }

    public List<byte[]> getMyMatrix() {
        return matrix;
    }
}
