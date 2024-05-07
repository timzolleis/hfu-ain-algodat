package task5;

import task2.Fraction;

public class ComparableFraction extends Fraction implements Comparable<Fraction> {

    public ComparableFraction(int numerator, int denominator) throws IllegalArgumentException {
        super(numerator, denominator);
    }

    @Override
    public int compareTo(Fraction o) {
        int crossNumerator = this.getNumerator() * o.getDenominator();
        int crossDenominator = this.getDenominator() * o.getNumerator();
        return crossNumerator - crossDenominator;
    }
}
