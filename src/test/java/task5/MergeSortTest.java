package task5;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;
import task2.Fraction;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void mergeSortWithIntegers() {
        Integer[] actual = {15, 3, 8, 9, 20, 70, 4, 6};
        Integer[] expected = {3, 4, 6, 8, 9, 15, 20, 70};
        final MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(actual);
        assertArrayEquals(actual, expected);
    }

    @Test
    void mergeSortWithStrings() {
        String[] actual = {"c", "a", "d", "f", "x", "g", "y", "e"};
        String[] expected = {"a", "c", "d", "e", "f", "g", "x", "y"};
        final MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(actual);
        assertArrayEquals(actual, expected);
    }


    @Test
    void mergeSortWithFractions() {
        ComparableFraction smallest = new ComparableFraction(5, 20);
        ComparableFraction middle = new ComparableFraction(3, 10);
        ComparableFraction largest = new ComparableFraction(1, 2);

        ComparableFraction[] actual = {middle, largest, smallest};
        ComparableFraction[] expected = {smallest, middle, largest};

        final MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(actual);
        assertArrayEquals(actual, expected);

    }

}