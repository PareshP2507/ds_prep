package sorting;

import java.util.Random;

class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.println("After:");
        printArray(array);
    }

    /**
     * Quick sort has 3 steps:
     * 1) Pivot: choose any number as a pivot.
     * 2) Partitioning: move all the elements less than the pivot to the left side
     * and elements greater than the pivot to the right side.
     * 3) Recursion: recursively quick sort left and right side of the array
     * 
     * @param array     - Array needs to be sorted.
     * @param lowIndex  - lowIndex of the array, initially would be 0
     * @param highIndex - highIndex of the arary, initially would be length - 1
     */
    private static void quickSort(int[] array, int lowIndex, int highIndex) {
        // Recursion will stopped when there is only on element in the array
        if (lowIndex >= highIndex) {
            return;
        }

        // Step 1: Choosing a pivot
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, highIndex, pivotIndex); // Move pivot to the end of array

        // Step 2: Partitioning
        // 1. The logic here is to move left pointer to the right until the element
        // greater
        // than the pivot is found. At the same time move right pointer to the left
        // until the element less than the pivot is found.
        // 2. Swap the element at the left pointer and the right pointer.
        // 3. Repeat this process until left pointer and right pointer meets.
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;
        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }

        if (array[leftPointer] > array[highIndex]) {
            swap(array, highIndex, leftPointer);
        } else {
            leftPointer = highIndex;
        }

        // Step 3: Recursively quick sort left array and right array
        quickSort(array, lowIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1, highIndex);
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}