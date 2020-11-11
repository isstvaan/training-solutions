package recursion;

public class Factorial {
    public long getFactorial(int n) {
        if (n > 1) {
            return n * getFactorial(n - 1);
        } else {
            return 1;
        }
    }
}
