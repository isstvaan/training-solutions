public class CylinderCalculator {

    public double calculateVolume(double r, double h) {
        return CircleCalculator.MATH_PI * r * r * h;
    }

    public double calculateSurfaceArea(double r, double h) {
        return 2 * CircleCalculator.MATH_PI * (r * (r + h));
    }
}
