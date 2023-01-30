package assignment;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[] {22, 31, 13, -5, -12, 23, 44, 16, 99, 101, 32, 54, 0, 1, 3, 11};
        printSort(array);
    }
    public static void printSort(int[] array) {
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        int i = 1;
        while (i < array.length) {
            int index = findIndex(array, i);
            moveElement(array, i, index);
            i++;
        }
    }
    private static int findIndex(int[] array, int endIndex) {
        int leftIndex = 0;
        int rightIndex = endIndex;
        while (true) {
            int midIndex = (leftIndex + rightIndex) / 2;
            if (array[midIndex]==array[endIndex]) return midIndex;
            if (leftIndex == midIndex) {
                if (array[endIndex] > array[midIndex]) return rightIndex;
                else return midIndex;
            }
            if (array[endIndex] > array[midIndex]) leftIndex = midIndex;
            else rightIndex = midIndex;
        }
    }
    private static void moveElement(int[] array, int numberFromIndex, int numberToIndex) {
        if (numberFromIndex == numberToIndex) return;
        int i = numberToIndex;
        int temp1 = array[numberFromIndex];
        while (i <= numberFromIndex) {
            int temp2 = array[i];
            array[i] = temp1;
            temp1 = temp2;
            i++;
        }
    }
}
