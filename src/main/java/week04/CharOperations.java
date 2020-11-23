package week04;

import java.util.ArrayList;
import java.util.List;

public class CharOperations {

    public static void main(String[] args) {
        System.out.println(new CharOperations().getIndexesOfChar("alma",'a').toString());
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
