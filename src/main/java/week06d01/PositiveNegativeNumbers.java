package week06d01;

public class PositiveNegativeNumbers {
    private double positiveNumber;
    private double negativeNumber;

    public PositiveNegativeNumbers(double positiveNumber, double negativeNumber) {
        this.positiveNumber = positiveNumber;
        this.negativeNumber = negativeNumber;
    }

    public double getPositiveNumber() {
        return positiveNumber;
    }

    public double getNegativeNumber() {
        return negativeNumber;
    }

    @Override
    public String toString() {
        return "positiveNumber=" + positiveNumber + ", negativeNumber=" + negativeNumber;

    }
}
