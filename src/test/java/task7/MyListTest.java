package task7;

import org.junit.jupiter.api.Test;
import task2.Fraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyListTest {

    @Test
    void addTest() {
        MyList<Integer> myList = new MyList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        assertEquals(3, myList.getSize());
    }

    @Test
    void get() {
        MyList<Integer> myList = new MyList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        assertEquals(1, myList.get(0));
        assertEquals(2, myList.get(1));
        assertEquals(3, myList.get(2));
    }

    @Test
    void remove() {
        MyList<Integer> myList = new MyList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        assertEquals(2, myList.remove(1));
        assertEquals(2, myList.getSize());
    }

    @Test
    void getSize() {
        MyList<Integer> myList = new MyList<>();
        assertEquals(0, myList.getSize());
    }


    @Test
    void exceptions() {
        MyList<Integer> myList = new MyList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> myList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> myList.remove(0));
    }

    @Test
    void withFractions() {
        MyList<Fraction> myList = new MyList<>();
        myList.add(new Fraction(1, 2));
        myList.add(new Fraction(1, 3));
        myList.add(new Fraction(1, 4));
        assertEquals(new Fraction(1, 2), myList.get(0));
        assertEquals(new Fraction(1, 3), myList.get(1));
        assertEquals(new Fraction(1, 4), myList.get(2));
        assertEquals(3, myList.getSize());

    }

}