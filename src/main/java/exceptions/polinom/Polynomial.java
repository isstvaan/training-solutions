package exceptions.polinom;

import java.security.spec.ECField;

public class Polynomial {
    private double[] coefficients;

    public Polynomial(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;
    }

    public Polynomial(String[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficientStrs is null");
        }
        this.coefficients = new double[coefficients.length];
        for (int i = 0; i < this.coefficients.length; i++) {
            try {
                this.coefficients[i] = Double.parseDouble(coefficients[i]);
            } catch (Exception ex) {
                throw new IllegalArgumentException("Illegal coefficients, not a number", ex);
            }
        }
    }

    public double evaluate(double x) {
        int n = coefficients.length - 1;
        double sum = 0;
        for (int j = n; j >= 0; j--) {
            sum += coefficients[j] * Math.pow(x, (double) n - j);
        }
        return sum;
    }

    public double[] getCoefficients() {
        return coefficients;
    }
}
