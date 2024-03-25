package task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestrictedCounterTest {

    private RestrictedCounter counter;

    @BeforeEach
    void setUp() {
        counter = new RestrictedCounter(15);
    }

    @Test
    void test() {
        for (int i = 0; i < 20; ++i) {
            if (i < 15) {
                counter.increment();
                final int count = counter.getCount();
                assertEquals(i + 1, count);
                assertEquals(15 - count, counter.freeCapacity());
            } else {
                assertThrows(IllegalStateException.class, counter::increment);
            }
        }
        assertEquals(15, counter.getCount());
        for (int i = 0; i < 20; ++i) {
            counter.decrement();
            final int count = counter.getCount();
            assertEquals(15 - count, counter.freeCapacity());
        }
        assertEquals(0, counter.getCount());
    }
}