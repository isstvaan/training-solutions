package week05d02;

import java.util.Arrays;
import java.util.List;

public class ChangeLetter {
    public String changeVowels(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("Parameter can't be empty");
        }
        return str.replaceAll("[aeiouAEIOU]", "*");
    }

    private List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public String changeVowels2(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("Parameter can't be empty");
        }

        String changedStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (vowels.contains(str.toLowerCase().charAt(i))) {
                changedStr += "*";
            } else {
                changedStr += str.charAt(i);
            }
        }

        return changedStr;
    }
}
