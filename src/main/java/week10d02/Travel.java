package week10d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Travel {

    public static final String SPLIT_CHAR = " ";
    public static final int STATION_INDEX = 0;
    public static final int STATIONS_NUMBER = 30;

    public int getStopWithMax(InputStream stream) {
        return getMaxValueIndex(fillListWithNumbers(stream));
    }

    public int[] fillListWithNumbers(InputStream stream) {
        int[] numbers = new int[STATIONS_NUMBER];
        try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while ((line = inputStream.readLine()) != null) {
                String[] splitted = line.split(SPLIT_CHAR);
                numbers[Integer.parseInt(splitted[STATION_INDEX])]++;
            }
        } catch (IOException e) {
            throw new IllegalStateException("File read error.", e);
        }
        return numbers;
    }

    public int getMaxValueIndex(int[] values) {
        int maxIndexValue = 0;
        int tmp = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > tmp) {
                tmp = values[i];
                maxIndexValue = i;
            }
        }
        return maxIndexValue;
    }

    public static void main(String[] args) {
        System.out.println(new Travel().getStopWithMax(Travel.class.getResourceAsStream("/utasadat.txt")));
    }
}
