package week08d02;

public class Country {
    private String name;
    private long population;
    private int flagColors;
    private int neighbor;

    public Country(String name, long population, int flagColors, int neighbor) {
        this.name = name;
        this.population = population;
        this.flagColors = flagColors;
        this.neighbor = neighbor;
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public int getFlagColors() {
        return flagColors;
    }

    public int getNeighbor() {
        return neighbor;
    }
}
