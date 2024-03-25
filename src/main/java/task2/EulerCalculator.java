package task2;

public class EulerCalculator {

    public static Fraction euler(final int n) {
        final Fraction fraction = new Fraction(1, 1);
        for (int i = 1; i <= n; i++) {
            final int factorial = factorial(i);
            fraction.add(new Fraction(1, factorial));
        }
        return fraction;
    }

    private static int factorial(final int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
