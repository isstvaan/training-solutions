package week10d01;

public class MaxClimbValue {
    private final int maxRise;
    private final int maxDescent;

    public MaxClimbValue(int maxRise, int maxDescent) {
        this.maxRise = maxRise;
        this.maxDescent = maxDescent;
    }

    public int getMaxRise() {
        return maxRise;
    }

    public int getMaxDescent() {
        return maxDescent;
    }

    @Override
    public String toString() {
        return "max rise=" + maxRise + ", max descent=" + maxDescent;
    }
}
