package methodparam.measuring;

public class ExtremValues {
    private double minimumValue;
    private double maximumValue;

    public ExtremValues(double minimumValue, double maximumValue) {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
    }

    public double getMin() {
        return minimumValue;
    }

    public double getMax() {
        return maximumValue;
    }
}
