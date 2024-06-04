package task5;

import java.util.Arrays;

public class MergeSort {

    public <T extends Comparable<? super T>> void mergeSort(T[] arrayToSort) {
        sort(arrayToSort, arrayToSort.length);
    }

    private <T extends Comparable<? super T>> void sort(final T[] arrayToSort, final int length) {
        if (length < 2) {
            return;
        }
        //Create new arrays with new lengths
        final int newLeftLength = length / 2;
        final int newRightLength = length - newLeftLength;

        T[] leftArray = Arrays.copyOfRange(arrayToSort, 0, newLeftLength);
        T[] rightArray = Arrays.copyOfRange(arrayToSort, newLeftLength, length);
        //Sort left
        sort(leftArray, newLeftLength);
        //Sort right
        sort(rightArray, newRightLength);
        //Merge arrays
        merge(arrayToSort, leftArray, rightArray, newLeftLength, newRightLength);
    }

    private <T extends Comparable<? super T>> void merge(final T[] arrayToSort, final T[] leftArray, final T[] rightArray, final int leftArrayLength, final int rightArrayLength) {
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int mainArrayIndex = 0;

        // Move through the arrays while i is less than leftIndex and j is less than rightIndex
        while (leftArrayIndex < leftArrayLength && rightArrayIndex < rightArrayLength) {
            final T leftElement = leftArray[leftArrayIndex];
            final T rightElement = rightArray[rightArrayIndex];
            final boolean leftLessThanRight = leftElement.compareTo(rightElement) < 0;

            if (leftLessThanRight) {
                arrayToSort[mainArrayIndex++] = leftArray[leftArrayIndex++];
            } else {
                arrayToSort[mainArrayIndex++] = rightArray[rightArrayIndex++];
            }
        }

        // Copy remaining elements from the left array
        while (leftArrayIndex < leftArrayLength) {
            arrayToSort[mainArrayIndex++] = leftArray[leftArrayIndex++];
        }

        // Copy remaining elements from the right array
        while (rightArrayIndex < rightArrayLength) {
            arrayToSort[mainArrayIndex++] = rightArray[rightArrayIndex++];

        }
    }
}
