package greetings;

import java.time.LocalTime;
import java.util.List;

public class Greetings {

    public String greeting(int hour, int minute) {
        LocalTime time = LocalTime.of(hour, minute);

        if (time.isAfter(LocalTime.of(5, 0)) && time.isBefore(LocalTime.of(9, 1))) {
            return "Jó reggelt";
        } else if (time.isAfter(LocalTime.of(9, 0)) && time.isBefore(LocalTime.of(18, 31))) {
            return "Jó napot";
        } else if (time.isAfter(LocalTime.of(18, 30)) && time.isBefore(LocalTime.of(20, 1))) {
            return "Jó estét";
        } else {
            return "Jó éjt";
        }
    }

    public static void main(String[] args) {
        System.out.println((char) (((int)'a')+1));

        Greetings greetings = new Greetings();
        System.out.println(greetings.greeting(4, 30));
        System.out.println(greetings.greeting(5, 0));
        System.out.println(greetings.greeting(5, 1));
        System.out.println(greetings.greeting(9, 0));
        System.out.println(greetings.greeting(9, 1));
        System.out.println(greetings.greeting(18, 30));
        System.out.println(greetings.greeting(18, 31));
        System.out.println(greetings.greeting(20, 0));
        System.out.println(greetings.greeting(20, 1));
    }
}
