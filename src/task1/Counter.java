package task1;

public class Counter {

    private int count;
    private Integer saved = null;

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

    public void save() {
        saved = count;
    }

    public void restore() {
        if (saved == null) {
            throw new IllegalStateException("The counter has not been saved yet.");
        }
        count = saved;
    }
}