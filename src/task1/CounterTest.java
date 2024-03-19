package task1;

public class CounterTest {


    public static void main(String[] args) {
        final CounterTest test = new CounterTest();
        test.testIncrement();
        test.testDecrement();
        test.testReset();
    }


    public void testIncrement() {
        final Counter counter = new Counter();
        for (int i = 0; i < 15; i++) {
            counter.increment();
        }
        final int valueAfterIncrement = counter.getCount();
        if (valueAfterIncrement != 15) {
            throw new AssertionError("Expected 15 but was " + valueAfterIncrement);
        }
        System.out.println("testIncrement passed");
    }

    public void testDecrement() {
        final Counter counter = new Counter();
        counter.increment();
        counter.decrement();
        final int valueAfterDecrement = counter.getCount();
        if (valueAfterDecrement != 0) {
            throw new AssertionError("Expected 0 but was " + valueAfterDecrement);
        }
        System.out.println("testDecrement passed");
    }

    public void testReset() {
        final Counter counter = new Counter();
        for (int i = 0; i < 10; i++) {
            counter.increment();
        }
        counter.reset();
        final int value = counter.getCount();
        if (value != 0) {
            throw new AssertionError("Expected 0 but was " + value);
        }
        System.out.println("testReset passed");
    }
}
