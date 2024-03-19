package task1;

public class CounterTest {


    public static void main(String[] args) {
        final CounterTest test = new CounterTest();
        test.runIncrement();
        test.runDecrement();
        test.runReset();
        test.runSave();
        test.runRestore();
    }


    public void runIncrement() {
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

    public void runDecrement() {
        final Counter counter = new Counter();
        counter.increment();
        counter.decrement();
        final int valueAfterDecrement = counter.getCount();
        if (valueAfterDecrement != 0) {
            throw new AssertionError("Expected 0 but was " + valueAfterDecrement);
        }
        System.out.println("testDecrement passed");
    }

    public void runReset() {
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

    public void runSave() {
        final Counter counter = new Counter();
        for (int i = 0; i < 10; i++) {
            counter.increment();
        }
        counter.save();
        final int value = counter.getCount();
        if (value != 10) {
            throw new AssertionError("Expected 10 but was " + value);
        }
        System.out.println("testSave passed");
    }


    public void runRestore() {
        try {
            final Counter counter = new Counter();
            counter.restore();
            throw new AssertionError("Expected IllegalStateException");
        } catch (IllegalStateException e) {
            System.out.println("testRestore validation passed");
        }
        final Counter counter = new Counter();
        for (int i = 0; i < 10; i++) {
            counter.increment();
        }
        counter.save();
        counter.reset();
        counter.restore();
        final int value = counter.getCount();
        if (value != 10) {
            throw new AssertionError("Expected 10 but was " + value);
        }
        System.out.println("testRestore passed");
    }


}
