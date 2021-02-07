package jvm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TesterClass {
    public List<Integer> ints = new ArrayList<>();

    public  List<Integer> getSortedList(int size)
    {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt());
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        while(true) {
            Random random = new Random();
            int size = random.nextInt(500_000);
            System.out.println("Creating and sorting list with size " + size);
            new TesterClass().getSortedList(size);
        }
    }
}
