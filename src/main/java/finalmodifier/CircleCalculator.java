package finalmodifier;

public class CircleCalculator {
    public final static double MATH_PI = 3.14;

    public double calculatePerimeter(double r) {
        return 2 * r * MATH_PI;
    }

    public double calculateArea(double r) {
        return r * r * MATH_PI;
    }
}
