package task2;

public class Fraction {
    private int numerator;
    private int denominator;


    public Fraction(int numerator, int denominator) throws IllegalArgumentException {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void add(Fraction fractionToAdd) {
        final int newNumerator = this.numerator * fractionToAdd.denominator + fractionToAdd.numerator * this.denominator;
        final int newDenominator = this.denominator * fractionToAdd.denominator;

        final int gcd = findGcd(newNumerator, newDenominator);
        this.numerator = newNumerator / gcd;
        this.denominator = newDenominator / gcd;
    }

    public void multiply(Fraction fractionToMultiply) {
        this.numerator *= fractionToMultiply.numerator;
        this.denominator *= fractionToMultiply.denominator;
        final int gcd = findGcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    public void divide(Fraction fractionToDivide) {
        final Fraction reversed = new Fraction(fractionToDivide.denominator, fractionToDivide.numerator);
        this.multiply(reversed);
    }

    private int findGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGcd(b, a % b);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", numerator, denominator);
    }
}
