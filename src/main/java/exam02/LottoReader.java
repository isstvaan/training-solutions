package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LottoReader {
    private static final int NUMBERS_COUNT = 90;
    private static final int WINNER_NUMBERS_START = 11;
    private static final int WINNER_NUMBERS_END = 15;

    private final int[] lottoNumbers = new int[NUMBERS_COUNT];

    public LottoReader(InputStream stream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int[] winnerNumbers = getWinnerNumbersIndex(line);
                setWinnerNumbersWithIndex(winnerNumbers);
            }
        } catch (IOException e) {
            throw new IllegalStateException("File read error");
        }
    }

    private int[] getWinnerNumbersIndex(String str) {
        String[] splitted = str.split(";");
        int[] numberIndexes = new int[WINNER_NUMBERS_END - WINNER_NUMBERS_START + 1];
        for (int i = WINNER_NUMBERS_START; i < splitted.length && i <= WINNER_NUMBERS_END; i++) {
            numberIndexes[i - WINNER_NUMBERS_START] = Integer.parseInt(splitted[i]) - 1;
        }
        return numberIndexes;
    }

    private void setWinnerNumbersWithIndex(int[] numberIndexes) {
        for (int item : numberIndexes) {
            lottoNumbers[item]++;
        }
    }

    public int getNumber(int i) {
        return lottoNumbers[i - 1];
    }
}
