package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class BandManager {
    private List<Band> bands = new ArrayList<>();

    public void readBandsFromFile(Path inputFile) {
        if (inputFile == null) {
            throw new IllegalArgumentException("Input file can't be null");
        }

        bands = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(inputFile)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bands.add(getBandFromString(line));
            }
        } catch (IOException ex) {
            throw new IllegalStateException("File read error", ex);
        }
    }

    private Band getBandFromString(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalStateException("String can't be empty");
        }
        String[] splittedStr = str.split(";");

        if (splittedStr.length < 2) {
            throw new IllegalStateException("Invalis string format.");
        }
        return new Band(splittedStr[0], Integer.parseInt(splittedStr[2]));
    }

    public void writeBandsBefore(Path outputFile, int year) {
        if (outputFile == null) {
            throw new IllegalArgumentException("Output file can't be null");
        }

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(outputFile, Files.exists(outputFile) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE_NEW)) {
            for (Band item : bands) {
                if (item.getYear() < year) {
                    bufferedWriter.write(item.getName() + ";" + item.getYear());
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException ex) {
            throw new IllegalStateException("Can't write file", ex);
        }
    }

}
