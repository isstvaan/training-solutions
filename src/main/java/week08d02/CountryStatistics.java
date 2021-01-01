package week08d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {
    private List<Country> countries = new ArrayList<>();

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }

    public void readCountriesFromFile(String fileName) {
        countries.clear();
        try (BufferedReader bufferedReader = new BufferedReader(Files.newBufferedReader(Path.of(fileName)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                countries.add(getCountryFromString(line));
            }
        } catch (IOException ex) {
            throw new IllegalStateException("Can't read file");
        }
    }

    private Country getCountryFromString(String str) {
        String[] spltStr = str.split(" ");
        if (spltStr.length < 4) {
            throw new IllegalArgumentException("Wrong string format");
        }
        return new Country(spltStr[0], Long.parseLong(spltStr[1]), Integer.parseInt(spltStr[2]), Integer.parseInt(spltStr[3]));
    }

    public Country maxPopulaton() {
        Country item = null;
        for (Country country : countries) {
            if (item == null || item.getPopulation() < country.getPopulation()) {
                item = country;
            }
        }
        return item;
    }

    public static void main(String[] args) {
        CountryStatistics countryStatistics = new CountryStatistics();
        countryStatistics.readCountriesFromFile("countries.txt");
        countryStatistics.maxPopulaton();
    }
}
