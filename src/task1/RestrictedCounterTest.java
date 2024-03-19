package task1;

public class RestrictedCounterTest {


    public static void main(String[] args) {
        final RestrictedCounterTest test = new RestrictedCounterTest();
        test.run();
    }

    private void run() {
        final RestrictedCounter counter = new RestrictedCounter(15);
        for (int i = 0; i < 20; ++i) {
            counter.increment();
            final String message = String.format("Counter: %s, Free capacity: %s", counter.getCount(), counter.freeCapacity());
            System.out.println(message);
        }
        for (int i = 0; i < 20; ++i) {
            counter.decrement();
            final String message = String.format("Counter: %s, Free capacity: %s", counter.getCount(), counter.freeCapacity());
            System.out.println(message);
        }
    }
}
