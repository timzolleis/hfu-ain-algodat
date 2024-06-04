
package task4;

import task1.Counter;

public class PowerFunctions {


    private static final Counter powerCounter = new Counter();
    private static final Counter fastPowerCounter = new Counter();


    public static double power(double x, int n) {
        double result = x;
        if (n < 0) {
            return 1 / power(x, -n);
        }
        while (n > 1) {
            powerCounter.increment();
            result *= x;
            n--;
        }
        return result;
    }

    public static double fastPower(double x, int n) {
        double result = 1;
        double base = x;
        final String binary = Integer.toBinaryString(n);
        for (int i = binary.length() - 1; i >= 0; i--) {
            fastPowerCounter.increment();
            if (binary.charAt(i) == '1') {
                result *= base;
            }
            base *= base;
        }
        return result;
    }

    public static void reset() {
        powerCounter.reset();
        fastPowerCounter.reset();
    }

    public static int getPowerCount() {
        return powerCounter.getCount();
    }

    public static int getFastPowerCount() {
        return fastPowerCounter.getCount();
    }


}
