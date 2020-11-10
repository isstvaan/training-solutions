package localvariables;

public class DistanceMain {
    public static void main(String[] args) {

        Distance distance = new Distance(60.74, false);
        System.out.println(distance.getDistance() + " " + distance.isPrecise());

        int intPart = (int) distance.getDistance();
        System.out.println(intPart);
    }
}
