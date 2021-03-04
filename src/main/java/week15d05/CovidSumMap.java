package week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CovidSumMap {
    private static final int NUMBER_INDEX = 2;
    private static final int COUNTRY_INDEX = 4;
    private static final int POPULATION_INDEX = 7;

    public List<CovidCasesPerCountry> count(BufferedReader reader) throws IOException {
        String line;
        reader.readLine();//Skip header

        Map<String, CovidCasesPerCountry> cases = new HashMap<>();
        while ((line = reader.readLine()) != null) {
            if (line.contains("Bonaire, Saint Eustatius and Saba")) {
                line = line.replace("Bonaire, Saint Eustatius and Saba", "Bonaire Saint Eustatius and Saba");
            }

            String[] splittedLine = line.split(",");
            if (!splittedLine[NUMBER_INDEX].isBlank() && !splittedLine[POPULATION_INDEX].isBlank()) {
                int number = Integer.parseInt(splittedLine[NUMBER_INDEX]);
                String country = splittedLine[COUNTRY_INDEX];
                int population = Integer.parseInt(splittedLine[POPULATION_INDEX]);

                if (!cases.containsKey(country)) {
                    cases.put(country, new CovidCasesPerCountry(country, population, 0));
                }
                cases.get(country).addCases(number);
            }
        }
        List<CovidCasesPerCountry> retVal = new ArrayList<>(cases.values());

        Collections.sort(retVal,Comparator.comparingDouble(CovidCasesPerCountry::getRate).reversed());
        System.out.println(retVal);
        return retVal.subList(0, 3);
    }

    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("covidDatas.csv"))) {
            System.out.println(new CovidSumMap().count(reader));
        } catch (IOException e) {
            throw new IllegalStateException("File read error");
        }
    }
}
