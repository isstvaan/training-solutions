package week15d05;

import java.util.Objects;

public class CovidCasesPerCountry {
    private final String country;
    private final int population;
    private int number;

    public CovidCasesPerCountry(String country, int population, int number) {
        this.country = country;
        this.population = population;
        this.number = number;
    }

    public CovidCasesPerCountry add(CovidCasesPerCountry covidCasesPerCountry) {
        return new CovidCasesPerCountry(country, population, number + covidCasesPerCountry.number);
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    public void addCases(int newCases) {
        number += newCases;
    }

    public int getNumber() {
        return number;
    }

    public double getRate() {
        if (population == 0) {
            return 0;
        }
        return number / (double) population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CovidCasesPerCountry that = (CovidCasesPerCountry) o;
        return country.equals(that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country);
    }

    @Override
    public String toString() {
        return "CovidCasesPerCountry{" +
                "country='" + country + '\'' +
                ", population=" + population +
                ", number=" + number +
                ", rate=" + getRate() +
                '}';
    }
}
