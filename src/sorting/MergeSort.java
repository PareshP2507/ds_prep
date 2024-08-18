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
        if (arrayLength < 2) {
            return;
        }
        int midIndex = arrayLength / 2;
        
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[arrayLength - midIndex];

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

    private static void merge(int[] array, int[] leftHalf, int[] rightHalf) {
        int leftHalfLength = leftHalf.length;
        int rightHalfLength = rightHalf.length;

        int i = 0, j = 0, k = 0;
        while (i < leftHalfLength && j < rightHalfLength) {
            if (leftHalf[i] < rightHalf[j]) {
                array[k] = leftHalf[i];
                i++;
            } else {
                array[k] = rightHalf[j];
                j++;
            }
            k++;
        }

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
