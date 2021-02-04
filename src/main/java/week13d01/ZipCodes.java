package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class ZipCodes {

    List<City> cities;

    public ZipCodes() {
        cities = new ArrayList<>();

        loadCities();
        sortCities();
    }

    private void loadCities() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ZipCodes.class.getResourceAsStream("/iranyitoszamok-varosok-2021.csv")))) {
            String line;
            reader.readLine();//DROP FIRST LINE
            while ((line = reader.readLine()) != null) {
                cities.add(City.fromCSVString(line));
            }
        } catch (IOException e) {
            throw new IllegalStateException("File read error");
        }
    }

    private void sortCities() {
        cities.sort(new Comparator<City>() {
            Collator collator = Collator.getInstance(new Locale("hu", "HU"));

            @Override
            public int compare(City o1, City o2) {
                return collator.compare(o1.getName(), o2.getName());
            }
        });
    }

    public City getFirstCity() {
        if (cities.isEmpty()) {
            throw new IllegalStateException("Empty list");
        }
        return cities.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new ZipCodes().getFirstCity());
    }
}
