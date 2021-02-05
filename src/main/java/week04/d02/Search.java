package week04.d02;

import java.util.ArrayList;
import java.util.List;

public class Search {

    public static void main(String[] args) {
        System.out.println(new Search().getIndexesOfChar("alma",'a').toString());
    }

    public List<Integer> getIndexesOfChar(String str, char chr) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == chr) {
                results.add(i);
            }
        }
        return results;
    }
}
