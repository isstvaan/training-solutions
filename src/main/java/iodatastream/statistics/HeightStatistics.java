package iodatastream.statistics;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HeightStatistics {
    public void saveHeights(List<Integer> heights, Path path) {
        if (path == null) {
            throw new IllegalArgumentException("Path can't be null");
        }

        if (heights == null) {
            throw new IllegalArgumentException("Heights can't be null");
        }

        try (DataOutputStream stream = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            stream.writeInt(heights.size());
            for (int item : heights) {
                stream.writeInt(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
