package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FractionTest {


    @Test
    void testBasicSum() {
        final Fraction fraction = new Fraction(1, 2);
        fraction.add(new Fraction(1, 4));
        Assertions.assertEquals("3/4", fraction.toString());
    }

    @Test
    void testSumWith5() {
        final int n = 5;
        final Fraction fraction = new Fraction(1, 1);
        for (int i = 2; i <= n; i++) {
            fraction.add(new Fraction(1, i));
        }
        Assertions.assertEquals("137/60", fraction.toString());
    }

    @Test
    void testSumWith10() {
        final int n = 10;
        final Fraction fraction = new Fraction(1, 1);
        for (int i = 2; i <= n; i++) {
            fraction.add(new Fraction(1, i));
        }
        Assertions.assertEquals("7381/2520", fraction.toString());
    }

    @Test
    void testMultiply() {
        final Fraction fraction = new Fraction(1, 2);
        fraction.multiply(new Fraction(2, 3));
        Assertions.assertEquals("1/3", fraction.toString());
    }

    @Test
    void testDivide() {
        final Fraction fraction = new Fraction(1, 2);
        fraction.divide(new Fraction(2, 3));
        Assertions.assertEquals("3/4", fraction.toString());
    }


    @Test
    void testEuler() {
        final Fraction fractionWith5 = EulerCalculator.euler(5);
        Assertions.assertEquals("163/60", fractionWith5.toString());
    }

    @Test
    void testToString() {
        final Fraction fraction = new Fraction(1, 2);
        Assertions.assertEquals("1/2", fraction.toString());
    }
}
