package sorting;

import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[11];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        printArray(array);

        mergeSort(array);

        System.out.println("After:");
        printArray(array);
    }

    private static void mergeSort(int[] array) {
        // Devide the array into tow half recursively
        int arrayLength = array.length;
        // Divide an array until the array has only one element
        if (arrayLength < 2) {
            return;
        }
        int midIndex = arrayLength / 2;

        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[arrayLength - midIndex];

        // Fill-up arrays
        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = array[i];
        }
        for (int i = midIndex; i < arrayLength; i++) {
            rightHalf[i - midIndex] = array[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // Merge the divided halves
        merge(array, leftHalf, rightHalf);
    }

    /**
     * Merge two sorted arrays. The strategy here is to get an element from the
     * begining of leftHalf and compare it with the rightHalf, whichever is less put
     * that in the result array
     * 
     * @param array     - Result array
     * @param leftHalf  - Already sorted left-half
     * @param rightHalf - Already sorted right-half
     */
    private static void merge(int[] array, int[] leftHalf, int[] rightHalf) {
        int leftHalfLength = leftHalf.length;
        int rightHalfLength = rightHalf.length;

        int i = 0, j = 0, k = 0;
        // Take the element from the left half and compare it with the right half
        while (i < leftHalfLength && j < rightHalfLength) {
            if (leftHalf[i] < rightHalf[j]) { // Left half is less
                array[k] = leftHalf[i];
                i++;
            } else { // Right half is less
                array[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        // Check for any left overs from left half and right half
        while (i < leftHalfLength) {
            array[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightHalfLength) {
            array[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
