package week10d05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static final int MAX_SUMM_NUMBER = 4;

    public static void findMinMaxSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Input parameter is not valid");
        }

        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        int min = 0;
        int max = 0;
        for (int i = 0; i < Math.min(MAX_SUMM_NUMBER, arr.length); i++) {
            min += arr[i];
            max += arr[arr.length - 1 - i];
        }
        System.out.printf("A legkissebbek összege: %d%nA legnagyobbak összege: %d", min, max);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();
        String s = scanner.nextLine();
        while (!s.isBlank()) {
            try {
                numbers.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("Számot írj!");
            }
            s = scanner.nextLine();
        }
        int[] data = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); ++i) {
            data[i] = numbers.get(i);
        }
        findMinMaxSum(data);
    }
}
