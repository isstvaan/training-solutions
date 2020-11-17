package methodparam.measuring;

public class Measurement {
    private double[] results;

    public Measurement(double[] results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Result can't be empty");
        }
        this.results = results;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        for (int i = 0; i < results.length; i++) {
            if (results[i] > lower && results[i] < upper) {
                return i;
            }
        }
        return -1;
    }

    public double minimum() {
        double minValue = Double.MAX_VALUE;
        for (double item : results) {
            minValue = item < minValue ? item : minValue;
        }
        return minValue;
    }

    public double maximum() {
        double maxValue = Double.MIN_VALUE;
        for (double item : results) {
            maxValue = item > maxValue ? item : maxValue;
        }
        return maxValue;
    }

    public ExtremValues minmax() {
        return new ExtremValues(minimum(), maximum());
    }
}
