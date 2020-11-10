package localvariables;

public class Distance {
    private double distance;
    private boolean precise;

    public Distance(double distance, boolean precise) {
        this.distance = distance;
        this.precise = precise;
    }

    public double getDistance() {
        return distance;
    }

    public boolean isPrecise() {
        return precise;
    }
}
