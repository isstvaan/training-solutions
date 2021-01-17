package week11d03;

import java.util.*;

public class CharCounter {
    public int countChars(String[] chars) {
        int result = 0;

        for (Character characterItem : chars[0].toCharArray()) {
            boolean charFounded = true;
            for (int i = 1; i < chars.length; i++) {
                charFounded = charFounded && chars[i].contains(characterItem.toString());
            }
            result = charFounded ? result + 1 : result;
        }

        return result;
    }

    public int countChars2(String[] chars) {
        int result = 0;

        if (chars.length > 0) {
            Set<Character> first = new HashSet<>();
            for (Character item : chars[0].toCharArray()) {
                first.add(item);
            }

            for (int i = 1; i < chars.length; i++) {
                Set<Character> next = new HashSet<>();
                for (Character item : chars[i].toCharArray()) {
                    next.add(item);
                }
                first.retainAll(next);
            }
            result = first.size();
        }

        return result;
    }
}
