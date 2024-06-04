package task5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest {

    @Test
    void mergeSortWithIntegers() {
        final Integer[] actual = {15, 3, 8, 9, 20, 70, 4, 6};
        final Integer[] expected = {3, 4, 6, 8, 9, 15, 20, 70};
        final MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(actual);
        assertArrayEquals(actual, expected);
    }

    @Test
    void mergeSortWithStrings() {
        final String[] actual = {"c", "a", "d", "f", "x", "g", "y", "e"};
        final String[] expected = {"a", "c", "d", "e", "f", "g", "x", "y"};
        final MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(actual);
        assertArrayEquals(actual, expected);
    }


    @Test
    void mergeSortWithFractions() {
        final ComparableFraction smallest = new ComparableFraction(5, 20);
        final ComparableFraction middle = new ComparableFraction(3, 10);
        final ComparableFraction largest = new ComparableFraction(1, 2);

        final ComparableFraction[] actual = {middle, largest, smallest};
        final ComparableFraction[] expected = {smallest, middle, largest};

        final MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(actual);
        assertArrayEquals(actual, expected);

    }

}