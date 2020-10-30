import java.util.Scanner;

public class BoatRental {
    public static void main(String[] args) {
        int boat1 = 5;
        int boat2 = 3;
        int boat3 = 2;

        System.out.println("Hány fő szeretne csónakázni?");
        Scanner scanner = new Scanner(System.in);
        int peoples = scanner.nextInt();

        boolean boat1IsOut = false;
        boolean boat2IsOut = false;
        boolean boat3IsOut = false;

        if (peoples > boat2) {
            boat1IsOut = true;
            peoples = peoples - boat1;
        }
        if (peoples > boat1) {
            boat2IsOut = true;
            peoples = peoples - boat2;
        }
        if (peoples > 0) {
            boat3IsOut = true;
            peoples = peoples - 2;
        }

        peoples = peoples > 0 ? peoples : 0;

        System.out.println("Kiadott csónakok:\n" +
                (boat1IsOut ? "\tegy 5 személyes csónak\n" : "") +
                (boat2IsOut ? "\tegy 3 személyes csónak\n" : "") +
                (boat3IsOut ? "\tegy 2 személyes csónak\n" : "") +
                "Bent maradt csónakok:\n" +
                (!boat1IsOut ? "\tegy 5 személyes csónak\n" : "") +
                (!boat2IsOut ? "\tegy 3 személyes csónak\n" : "") +
                (!boat3IsOut ? "\tegy 2 személyes csónak\n" : "") +
                "Akiknek nem jutott csónak: " + peoples);
    }


}
