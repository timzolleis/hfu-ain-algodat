package task5;

import java.util.Arrays;

public class MergeSort {

    public <T> void mergeSort(Comparable<T>[] arrayToSort) {
        sort(arrayToSort, arrayToSort.length);
    }

    private <T> void sort(Comparable<T>[] arrayToSort, int length) {
        if (length < 2) {
            return;
        }
        //Split arrays into half
        int mid = length / 2;

        //Create new arrays with new lengths
        int newLeftLength = mid;
        int newRightLength = length - mid;

        Comparable<T>[] leftArray = new Comparable[newLeftLength];
        Comparable<T>[] rightArray = new Comparable[newRightLength];

        //Copy values in arrays
        for (int index = 0; index < newLeftLength; index++) {
            leftArray[index] = arrayToSort[index];
        }
        for (int index = newLeftLength; index < length; index++) {
            rightArray[index - newLeftLength] = arrayToSort[index];
        }
        //Sort left
        sort(leftArray, newLeftLength);
        //Sort right
        sort(rightArray, newRightLength);
        //Merge arrays
        merge(arrayToSort, leftArray, rightArray, newLeftLength, newRightLength);
    }

    private void merge(Comparable[] arrayToSort, Comparable[] leftArray, Comparable[] rightArray, int leftArrayLength, int rightArrayLength) {
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int mainArrayIndex = 0;

        // Move through the arrays while i is less than leftIndex and j is less than rightIndex
        while (leftArrayIndex < leftArrayLength && rightArrayIndex < rightArrayLength) {
            boolean leftElementIsBiggerThanRightElement = leftArray[leftArrayIndex].compareTo(rightArray[rightArrayIndex]) < 0;

            if (leftElementIsBiggerThanRightElement) {
                arrayToSort[mainArrayIndex++] = leftArray[leftArrayIndex++];
            } else {
                arrayToSort[mainArrayIndex++] = rightArray[rightArrayIndex++];
            }
        }

        // Copy remaining elements from left array
        while (leftArrayIndex < leftArrayLength) {
            arrayToSort[mainArrayIndex++] = leftArray[leftArrayIndex++];
        }

        // Copy remaining elements from right array
        while (rightArrayIndex < rightArrayLength) {
            arrayToSort[mainArrayIndex++] = rightArray[rightArrayIndex++];

        }
    }
}
