package task8;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DaysOfWeekTest {


    @Test
    void printList() {
        System.out.println("-- List --");
        final List<String> daysOfWeek = new DaysOfWeek().getDaysOfWeek();
        daysOfWeek.forEach(System.out::println);
        assertEquals(7, daysOfWeek.size());
        System.out.println("-- Every second element --");
        new DaysOfWeek().printEverySecondElement(daysOfWeek.iterator());
    }

    @Test
    void printHashSet() {
        System.out.println("-- HashSet --");
        final Set<String> daysOfWeek = new DaysOfWeek().getHashSet();
        daysOfWeek.forEach(System.out::println);
        assertEquals(7, daysOfWeek.size());
        System.out.println("-- Every second element --");
        new DaysOfWeek().printEverySecondElement(daysOfWeek.iterator());
    }

    @Test
    void printTreeSet() {
        System.out.println("-- TreeSet --");
        final Set<String> daysOfWeek = new DaysOfWeek().getTreeSet();
        daysOfWeek.forEach(System.out::println);
        assertEquals(7, daysOfWeek.size());
        System.out.println("-- Every second element --");
        new DaysOfWeek().printEverySecondElement(daysOfWeek.iterator());
    }


}