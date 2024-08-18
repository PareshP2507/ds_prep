package sorting;

import java.util.Random;

/**
 * Bubblesort is swapping the element untill there is no swap operation
 * is performed.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[11];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        printArray(array);

        boolean hasSwapped = true;
        while (hasSwapped) {
            hasSwapped = false;
            for (int i = 0; i <  array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    hasSwapped = true;
                    swap(array, i, i + 1);
                }
            }
        }

        System.out.println("After:");
        printArray(array);
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
