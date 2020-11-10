package numbers;

public class Circle {
    public final static double MATH_PI = 3.14;

    private int diameter;

    public Circle(int diameter) {
        this.diameter = diameter;
    }

    public double area() {
        return (Math.pow(diameter, 2) * MATH_PI) / 4;
    }

    public double permiter() {
        return diameter * MATH_PI;
    }

}
