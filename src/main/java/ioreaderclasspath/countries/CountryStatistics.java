package ioreaderclasspath.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {
    private final List<Country> countries = new ArrayList<>();

    public List<Country> getCountryList() {
        return new ArrayList<>(countries);
    }

    public void readFromFile(String pathStr) {
        if (pathStr == null || pathStr.isBlank()) {
            throw new IllegalStateException("Path can't be null or empty");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CountryStatistics.class.getResourceAsStream(pathStr)))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] splittedStr = line.split(" ");
                countries.add(new Country(splittedStr[0], Integer.parseInt(splittedStr[1])));
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can't read file.");
        }
    }

    public int numberOFCountries() {
        return countries.size();
    }

    public Country mostBorderCountries() {
        if (countries.isEmpty()) {
            throw new IllegalStateException("Countries list is empty");
        }

        Country mostCountry = countries.get(0);
        for (Country item : countries) {
            if (mostCountry.getBorderCountries() < item.getBorderCountries()) {
                mostCountry = item;
            }
        }

        return mostCountry;
    }
}
