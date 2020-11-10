package week02;

import java.util.ArrayList;
import java.util.List;

public class Languages {
    public static void main(String[] args) {
        List<String> languagesList = new ArrayList<>();

        languagesList.add("Java");
        languagesList.add("Python");
        languagesList.add("JavaScript");

        for (String item : languagesList) {
            if (item.length() > 5) {
                System.out.println(item);
            }
        }
    }
}
