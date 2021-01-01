package week08d03;


import java.util.ArrayList;
import java.util.List;

public class StringLists {
    public List<String> shortestWords(List<String> words) {
        List<String> shortWords = new ArrayList<>();

        if (words.size() < 1) {
            throw new IllegalArgumentException("To short list");
        }

        shortWords.add(words.get(0));
        for (String word : words) {
            if (shortWords.get(0).length() > word.length()) {
                shortWords.clear();
                shortWords.add(word);
            } else if (shortWords.get(0).length() == word.length()) {
                shortWords.add(word);
            }
        }
        return shortWords;
    }

    public static void main(String[] args) {
        System.out.println(new StringLists().shortestWords(List.of("aaa", "aa", "bb", "cccc", "dd")));
    }
}
