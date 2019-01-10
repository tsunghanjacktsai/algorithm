package pers.jack.dynamicprogramming;

public class Factorial {
    public static long getFactorial1(int n) { //遞歸
        if (n == 1) {
            return 1L;
        }
        return (long) n * getFactorial1(n - 1);
    }

    public static long getFactorial2(int n) {
        long result = 1L;
        for (int i = 1; i <= n; i++) {
            result *= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(getFactorial1(n));
        System.out.println(getFactorial2(n));
    }
}
