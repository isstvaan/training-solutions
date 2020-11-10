package arrayofarrays;

import java.time.LocalDate;

public class ArrayOfArraysMain {

    public static void main(String[] args) {
        int[][] multiplicationArray = multiplicationTable(10);

        System.out.println(printArrayOfArrays(multiplicationArray));

        System.out.println(printArrayOfArraysPadLeft(multiplicationArray, 4, '_'));

        System.out.println(printArrayOfArrays(triangularMatrix(5)));

        System.out.println(printArrayOfArrays(getValues()));

    }

    private static int[][] multiplicationTable(int size) {
        int[][] tmp = new int[size][size];
        for (int i = 1; i <= tmp.length; i++) {
            for (int j = 1; j <= tmp[i - 1].length; j++) {
                tmp[i - 1][j - 1] = i * j;
            }
        }
        return tmp;
    }

    private static String printArrayOfArrays(int[][] array) {
        String retVal = "";
        for (int i = 0; i < array.length; i++) {
            String tmp = "";
            for (int j = 0; j < array[i].length; j++) {
                tmp += array[i][j] + " ";
            }
            retVal += tmp + "\n";
        }
        return retVal;
    }

    private static String printArrayOfArraysPadLeft(int[][] array, int padLength, char padChar) {
        String retVal = "";
        for (int i = 0; i < array.length; i++) {
            String tmp = "";
            for (int j = 0; j < array[i].length; j++) {
                tmp += padLeft(array[i][j], padLength, padChar) + " ";
            }
            retVal += tmp + "\n";
        }
        return retVal;
    }

    private static int[][] triangularMatrix(int size) {
        int[][] triangularMatrix = new int[size][];

        for (int i = 0; i < size; i++) {
            triangularMatrix[i] = getFilledArray(i + 1, i);
        }
        return triangularMatrix;
    }

    private static int[] getFilledArray(int size, int defaultValue) {
        int[] tmp = new int[size];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = defaultValue;
        }
        return tmp;
    }

    private static int[][] getValues() {
        int[][] dayOfMonths = new int[12][];

        for (int i = 1; i <= 12; i++) {
            dayOfMonths[i - 1] = new int[LocalDate.of(LocalDate.now().getYear(), i, 1).lengthOfMonth()];
        }
        return dayOfMonths;
    }

    private static String padLeft(int value, int maxLength, char paddingChar) {
        String tmp = "";
        for (int i = 0; i < maxLength - String.valueOf(value).length(); i++) {
            tmp += paddingChar;
        }

        return tmp + value;
    }

}
