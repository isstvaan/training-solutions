package arrays;

import java.time.LocalDate;
import java.util.*;

public class ArraysMain {
    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();

        System.out.println(arraysMain.numberOfDaysAsString());

        System.out.println(arraysMain.daysOfWeek());

        System.out.println(arraysMain.sameTempValues(new double[]{1.5, 2.5, 3.5}, new double[]{1.4, 2.4, 3.4}));
        System.out.println(arraysMain.sameTempValues(new double[]{1.5, 2.5, 3.5}, new double[]{1.5, 2.5, 3.5}));

        int[] myNumbers = new int[]{1, 5, 2, 3, 4};
        int[] winnerNumbers = new int[]{1, 2, 3, 5, 4};
        boolean isWinner = arraysMain.wonLottery(myNumbers, winnerNumbers);
        System.out.println(isWinner ? "Megnyerted a lottót gratulálunk!" : "Sajnos Ön most nem nyert a lottón");

        System.out.println("Megtett számok:" + Arrays.toString(myNumbers));
        System.out.println("Kihúzott számok:" + Arrays.toString(winnerNumbers));

        System.out.println(arraysMain.sameTempValuesDaylight(new double[]{1.5, 3.5}, new double[]{1.5, 2.4, 3.4}));
        System.out.println(arraysMain.sameTempValuesDaylight(new double[]{1.5, 2.5, 3.5}, new double[]{1.5, 2.5}));

    }

    public String numberOfDaysAsString() {
        int[] daysOfMonth = new int[12];

        for (int i = 0; i < 12; i++) {
            daysOfMonth[i] = LocalDate.of(LocalDate.now().getYear(), i + 1, 1).lengthOfMonth();
        }
        return Arrays.toString((daysOfMonth));
    }

    public List<String> daysOfWeek() {
        return Arrays.asList("Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap");
    }

    private String multiplicationTableAsString(int size) {
        int[][] tmp = new int[size][size];
        for (int i = 1; i <= tmp.length; i++) {
            for (int j = 1; j <= tmp[i - 1].length; j++) {
                tmp[i - 1][j - 1] = i * j;
            }
        }
        return Arrays.deepToString(tmp);
    }

    private boolean sameTempValues(double[] day, double[] anotherDay) {
        return Arrays.equals(day, anotherDay);
    }

    private boolean wonLottery(int[] winnerNumbers, int[] yourNumbers) {
        int[] winNumCopy = Arrays.copyOf(winnerNumbers, winnerNumbers.length);
        int[] yourNumCopy = Arrays.copyOf(yourNumbers, yourNumbers.length);

        Arrays.sort(winNumCopy);
        Arrays.sort(yourNumCopy);

        return Arrays.equals(winNumCopy, yourNumCopy);
    }

    private boolean sameTempValuesDaylight(double[] day, double[] anotherDay) {
        int minRange = day.length <= anotherDay.length ? day.length : anotherDay.length;
        double[] dayCopy = Arrays.copyOfRange(day, 0, minRange);
        double[] anotherDaysCopy = Arrays.copyOfRange(anotherDay, 0, minRange);

        return Arrays.equals(dayCopy, anotherDaysCopy);
    }
}
