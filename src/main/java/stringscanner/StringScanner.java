package stringscanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringScanner {

    public int readAndSumValues(String intString, String delimiter) {
        if (isEmpty(intString) ) {
            throw new IllegalArgumentException("Invalid parameter!");
        }

        int sumvalue = 0;
        Scanner scanner = new Scanner(intString);
        if (!isEmpty(delimiter)) {
            scanner.useDelimiter(delimiter);
        }
        try {
            while (scanner.hasNext()) {
                sumvalue += scanner.nextInt();
            }
        } catch (InputMismatchException ex) {
            throw new IllegalArgumentException("Incorrect parameter string!", ex);
        }
        return sumvalue;
    }

    public int readAndSumValues(String intString) {
        return readAndSumValues(intString, null);
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        if (isEmpty(text) ||  word == null || "".equals(word)) {
            throw new IllegalArgumentException("Invalid parameter!");
        }

        Scanner scanner = new Scanner(text);
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            String textLine = scanner.nextLine();
            if (textLine.contains(word)) {
                stringBuilder.append(textLine).append("\n");
            }
        }

        return stringBuilder.toString().trim();
    }

    private boolean isEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }
}
