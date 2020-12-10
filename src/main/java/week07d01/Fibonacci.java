package week07d01;

public class Fibonacci {

    public long fib(int n) {
        long a = 0;
        long b = 1;
        long c = 0;

        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
