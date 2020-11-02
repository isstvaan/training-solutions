public class CylinderCalculatorBasedOnCircle {

    public double calculateVolume(double r, double h) {
        return new CircleCalculator().calculateArea(r) * h;
    }

    public double calculateSurfaceArea(double r, double h) {
        return new CircleCalculator().calculatePerimeter(r) * (r + h);
    }

    public static void main(String[] args) {


        System.out.println("Henger felszíne:" + new CylinderCalculator().calculateSurfaceArea(4, 3));
        System.out.println("Henger térfogata:" + new CylinderCalculator().calculateVolume(4, 3));


        System.out.println("Henger felszíne:" + new CylinderCalculatorBasedOnCircle().calculateSurfaceArea(4, 3));
        System.out.println("Henger térfogata:" + new CylinderCalculatorBasedOnCircle().calculateVolume(4, 3));

    }
}
