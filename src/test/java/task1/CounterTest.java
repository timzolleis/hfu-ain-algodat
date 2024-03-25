package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    @Test
    void increment() {
        final Counter counter = new Counter();
        for (int i = 0; i < 15; i++) {
            counter.increment();
        }
        final int value = counter.getCount();
        assertEquals(15, value);
    }

    @Test
    void decrement() {
        final Counter counter = new Counter();
        counter.increment();
        counter.decrement();
        assertEquals(0, counter.getCount());
        assertThrows(IllegalStateException.class, counter::decrement);
    }

    @Test
    void getCount() {
        final Counter counter = new Counter();
        final int count = counter.getCount();
        assertEquals(0, count);
    }

    @Test
    void reset() {
        final Counter counter = new Counter();
        for (int i = 0; i < 10; i++) {
            counter.increment();
        }
        counter.reset();
        final int value = counter.getCount();
        assertEquals(0, value);
    }

    @Test
    void save() {
        final Counter counter = new Counter();
        for (int i = 0; i < 10; i++) {
            counter.increment();
        }
        counter.save();
        counter.increment();
        counter.restore();
        final int value = counter.getCount();
        assertEquals(10, value);
    }

    @Test
    void restore() {
        final Counter counter = new Counter();
        assertThrows(IllegalStateException.class, counter::restore);
        for (int i = 0; i < 10; i++) {
            counter.increment();
        }
        counter.save();
        counter.reset();
        counter.restore();
        final int value = counter.getCount();
        assertEquals(10, value);
    }
}