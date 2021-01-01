package week08d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Plane {

    public static int getMaxOcean() {
        int oceanCounter = 0;
        try (BufferedReader reader = new BufferedReader(Files.newBufferedReader(Path.of("map.txt")))) {
            char[] readChr = new char[1];
            int tmp = 0;
            while (reader.read(readChr) > 0) {
                if (readChr[0] == '0') {
                    tmp++;
                } else {
                    oceanCounter = tmp > oceanCounter ? tmp : oceanCounter;
                    tmp = 0;
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("File read error", e);
        }
        return oceanCounter;
    }

    public static void main(String[] args) {
        System.out.println(Plane.getMaxOcean());
    }
}
