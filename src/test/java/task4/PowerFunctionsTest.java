package task4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerFunctionsTest {


    @AfterEach
    void tearDown() {
        PowerFunctions.reset();
    }

    @Test
    void power() {
        final double base = 2;
        final int exponent = 3;
        final double result = PowerFunctions.power(base, exponent);
        assertEquals(8, result);
        final int count = PowerFunctions.getPowerCount();
        System.out.println("Calculated 2^3 in " + count + " iterations");

    }

    @Test
    void fastPower() {
        final double base = 2;
        final int exponent = 3;
        final double result = PowerFunctions.fastPower(base, exponent);
        assertEquals(8, result);
        final int count = PowerFunctions.getFastPowerCount();
        System.out.println("Calculated 2^3 in " + count + " iterations");
    }

    @Test
    void compareMethods() {
        final int iterations = 10000;
        final Random random = new Random();
        double averageExponent = 0;
        double averagePowerCount = 0;
        double averageFastPowerCount = 0;
        for (int i = 0; i < iterations; i++) {
            final double base = random.nextDouble();
            final int exponent = random.nextInt(1000);
            averageExponent += exponent;
            PowerFunctions.power(base, exponent);
            PowerFunctions.fastPower(base, exponent);
            final int powerCount = PowerFunctions.getPowerCount();
            final int fastPowerCount = PowerFunctions.getFastPowerCount();
            averagePowerCount += powerCount;
            averageFastPowerCount += fastPowerCount;
            PowerFunctions.reset();
            random.setSeed(System.currentTimeMillis());
        }
        averageExponent /= iterations;
        averagePowerCount /= iterations;
        averageFastPowerCount /= iterations;
        System.out.println("Average exponent: " + averageExponent);
        System.out.println("Average power count: " + averagePowerCount);
        System.out.println("Average fast power count: " + averageFastPowerCount);
    }
}