package exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Histogram {
    public static final String FILL_CHAR = "*";

    public String getHistogramFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader reader = Files.newBufferedReader(Path.of(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                int repeatNumber = Integer.parseInt(line);
                builder.append(FILL_CHAR.repeat(repeatNumber))
                        .append("\n");
            }

        } catch (IOException e) {
            throw new IllegalStateException("File read error");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println( new Histogram().getHistogramFromFile("exam2test.txt"));
    }
}
