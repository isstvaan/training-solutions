package week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CovidSum {
    private static final int NUMBER_INDEX = 2;
    private static final int COUNTRY_INDEX = 4;
    private static final int POPULATION_INDEX = 7;

    public List<CovidCasesPerCountry> count(BufferedReader reader) throws IOException {
        List<CovidCasesPerCountry> retVal = new ArrayList<>();
        String line;
        reader.readLine();//Skip header

//        String prevCountry = "";
//        int sum = 0;
//        int prevPopulation = 0;
        while ((line = reader.readLine()) != null) {
            if (line.contains("Bonaire, Saint Eustatius and Saba")) {
                line = line.replace("Bonaire, Saint Eustatius and Saba", "Bonaire Saint Eustatius and Saba");
            }

            String[] splittedLine = line.split(",");
            if (!splittedLine[NUMBER_INDEX].isBlank() && !splittedLine[POPULATION_INDEX].isBlank()) {
                int number = Integer.parseInt(splittedLine[NUMBER_INDEX]);
                String country = splittedLine[COUNTRY_INDEX];
                int population = Integer.parseInt(splittedLine[POPULATION_INDEX]);

                CovidCasesPerCountry cases = new CovidCasesPerCountry(country, population, 0);
                if (!retVal.contains(cases)) {
                    retVal.add(cases);
                }
                retVal.get(retVal.indexOf(cases)).addCases(number);

//                if (country.equalsIgnoreCase(prevCountry)) {
//                    sum += number;
//                } else {
//                    if (!prevCountry.equals("")) {
//                        retVal.add(new CovidCasesPerCountry(prevCountry, prevPopulation, sum));
//                    }
//                    sum = number;
//                }
//                prevCountry = country;
//                prevPopulation = population;
            }
        }
        //    retVal.add(new CovidCasesPerCountry(prevCountry, prevPopulation, sum));

        Collections.sort(retVal, (x, y) -> Double.compare(y.getRate(), x.getRate()));
        System.out.println(retVal);
        return retVal.subList(0, 3);
    }

    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("covidDatas.csv"))) {
            System.out.println(new CovidSum().count(reader));
        } catch (IOException e) {
            throw new IllegalStateException("File read error");
        }
    }
}
