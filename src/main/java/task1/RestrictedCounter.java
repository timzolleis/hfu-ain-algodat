package task1;

public class RestrictedCounter extends Counter {

    private final int maxValue;

    public RestrictedCounter(int maxValue) {
        super();
        this.maxValue = maxValue;
    }

    @Override
    public void increment() throws IllegalStateException {
        if (getCount() >= maxValue) {
            throw new IllegalStateException("The counter has reached its maximum value");
        }
        super.increment();
    }

    public int freeCapacity() {
        return maxValue - getCount();
    }


}
