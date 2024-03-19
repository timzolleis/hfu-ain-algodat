package task1;

public class RestrictedCounter extends Counter {

    private final int maxValue;

    public RestrictedCounter(int maxValue) {
        super();
        this.maxValue = maxValue;
    }

    @Override
    public void increment() {
        if (getCount() < maxValue) {
            super.increment();
        } else {
            System.out.println("The counter has reached its maximum value.");
        }
    }

    public int freeCapacity() {
        return maxValue - getCount();
    }


}
