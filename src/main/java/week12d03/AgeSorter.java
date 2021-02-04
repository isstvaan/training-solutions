package week12d03;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AgeSorter {
    public static final int MAX_AGE = 100;

    public int[] sortAges(int[] ages) {
        int[] tmpAges = new int[MAX_AGE + 1];
        for (int item : ages) {
            tmpAges[item]++;
        }

        List<Integer> retValList = new ArrayList<>();
        for (int i = 0; i < tmpAges.length; i++) {
            for (int j = 0; j < tmpAges[i]; j++) {
                retValList.add(i);
            }
        }
        int[] retArray = new int[retValList.size()];
        for (int i = 0; i < retValList.size(); i++) {
            retArray[i] = retValList.get(i);
        }
        return retArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AgeSorter().sortAges(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1})));
    }
}
