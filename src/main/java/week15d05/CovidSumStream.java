package week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CovidSumStream {
    private static final int NUMBER_INDEX = 2;
    private static final int COUNTRY_INDEX = 4;
    private static final int POPULATION_INDEX = 7;

    private CovidCasesPerCountry parse(String str) {
        String[] splittedLine = str.split(",");
        if (!splittedLine[NUMBER_INDEX].isBlank() && !splittedLine[POPULATION_INDEX].isBlank()) {
            int number = Integer.parseInt(splittedLine[NUMBER_INDEX]);
            String country = splittedLine[COUNTRY_INDEX];
            int population = Integer.parseInt(splittedLine[POPULATION_INDEX]);
            return new CovidCasesPerCountry(country, population, number);
        }
        return new CovidCasesPerCountry(null, 0, 0);
    }

    public List<CovidCasesPerCountry> count(BufferedReader reader) throws IOException {
        Map<String, CovidCasesPerCountry> cases = reader
                .lines()
                .skip(1)
                .map(s -> s.replace("Bonaire, Saint Eustatius and Saba", "Bonaire Saint Eustatius and Saba"))
                .map(this::parse)
                .filter(c -> c.getCountry() != null)
                .collect(
                        Collectors.toMap(
                                CovidCasesPerCountry::getCountry,
                                Function.identity(),
                                CovidCasesPerCountry::add));
        List<CovidCasesPerCountry> retVal = new ArrayList<>(cases.values());

       return cases
               .values()
               .stream()
               .sorted(Comparator.comparing(CovidCasesPerCountry::getRate).reversed())
               .limit(3)
               .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("covidDatas.csv"))) {
            System.out.println(new CovidSumStream().count(reader));
        } catch (IOException e) {
            throw new IllegalStateException("File read error");
        }
    }
}
