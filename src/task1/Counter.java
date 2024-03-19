package task1;

public class Counter {

    private int count;

    public Counter() {
        count = 0;
    }

    public void increment() {
        count++;
    }

    public void decrement() {
        if (count >= 1) {
            count--;

        }
    }

    public int getCount() {
        return count;
    }

    public void reset() {
        count = 0;
    }
}
