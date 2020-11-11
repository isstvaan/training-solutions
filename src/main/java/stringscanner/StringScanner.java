package stringscanner;

import java.util.Scanner;

public class StringScanner {

    public int readAndSumValues(String intString, String delimiter) {
        if (isEmpty(intString) || isEmpty(delimiter)) {
            throw new IllegalArgumentException("Invalid parameter!");
        }

        int sumvalue = 0;
        Scanner scanner = new Scanner(intString);
        scanner.useDelimiter(delimiter);

        while (scanner.hasNextInt()) {
            sumvalue += scanner.nextInt();
        }
        return sumvalue;
    }

    public int readAndSumValues(String intString) {
        return readAndSumValues(intString, new Scanner("null").delimiter().pattern());
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        if (isEmpty(text) || isEmpty(word)) {
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

        return stringBuilder.toString();
    }

    private boolean isEmpty(String string) {
        return string != null && string.isBlank();
    }
}
