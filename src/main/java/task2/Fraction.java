package task2;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Fraction {
    private int numerator;
    private int denominator;


    public Fraction(final int numerator, final int denominator) throws IllegalArgumentException {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void add(final Fraction fractionToAdd) {
        final int newNumerator = this.numerator * fractionToAdd.denominator + fractionToAdd.numerator * this.denominator;
        final int newDenominator = this.denominator * fractionToAdd.denominator;

        final int gcd = findGcd(newNumerator, newDenominator);
        this.numerator = newNumerator / gcd;
        this.denominator = newDenominator / gcd;
    }

    public void multiply(final Fraction fractionToMultiply) {
        this.numerator *= fractionToMultiply.numerator;
        this.denominator *= fractionToMultiply.denominator;
        final int gcd = findGcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    public void divide(final Fraction fractionToDivide) {
        final Fraction reversed = new Fraction(fractionToDivide.denominator, fractionToDivide.numerator);
        this.multiply(reversed);
    }

    private int findGcd(final int a, final int b) {
        if (b == 0) {
            return a;
        }
        return findGcd(b, a % b);
    }

    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public String toString() {
        return String.format("%d/%d", numerator, denominator);
    }
}
