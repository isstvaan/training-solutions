package week09d02;

public class FibCalculator {
    public static long sumEvens(int bound) {
        long sum = 0;
        long one = 0;
        long two = 1;

        while (two < bound) {
            sum = two % 2 == 0 ? sum + two : sum;
            long next = two + one;
            one = two;
            two = next;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(FibCalculator.sumEvens(10000));
    }
}
