package algorithm_practice;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{-10, -11, 0, 13, 99, 23, 32, 55, 59, -96, 100, 112, 4, 7, -88, 2001, 999, -121, 113, -145, -500, 0, 99, 13, 56, 19};
        //System.out.println(Arrays.toString(selectionSortForLoop(nums)));
        //System.out.println(Arrays.toString(selectionSortWhileLoop(nums)));
        //System.out.println(Arrays.toString(selectionSortDoWhileLoop(nums)));
        System.out.println(Arrays.toString(selectionSortRecursion(nums)));
    }

    public static int[] selectionSortForLoop(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            int indexOfMinNumber = i;
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[j] < inputArray[indexOfMinNumber]) {
                    indexOfMinNumber = j;
                }
            }
            int minNumber = inputArray[indexOfMinNumber];
            inputArray[indexOfMinNumber] = inputArray[i];
            inputArray[i] = minNumber;
        }
        return inputArray;
    }

    public static int[] selectionSortWhileLoop(int[] inputArray) {
        int i = 0;
        while (i < inputArray.length) {
            int j = i + 1;
            int indexOfMinNumber = i;
            while (j < inputArray.length) {
                if (inputArray[j] < inputArray[indexOfMinNumber]) {
                    indexOfMinNumber = j;
                }
                j++;
            }
            int minNumber = inputArray[indexOfMinNumber];
            inputArray[indexOfMinNumber] = inputArray[i];
            inputArray[i] = minNumber;
            i++;
        }
        return inputArray;
    }

    public static int[] selectionSortDoWhileLoop(int[] inputArray) {
        int i = 0;
        do {
            int j = i + 1;
            int indexOfMinNumber = i;
            do {
                if (inputArray[j] < inputArray[indexOfMinNumber]) {
                    indexOfMinNumber = j;
                }
                j++;
            } while (j < inputArray.length);
            int minNumber = inputArray[indexOfMinNumber];
            inputArray[indexOfMinNumber] = inputArray[i];
            inputArray[i] = minNumber;
            i++;
        } while (i < inputArray.length - 1);
        return inputArray;
    }

    public static int[] selectionSortRecursion(int[] inputArray) {
        selectionSortRecursionImplement(inputArray, 0, 1, 0);
        return inputArray;
    }

    public static int[] selectionSortRecursionImplement(int[] inputArray, int placeIndex, int iterationIndex, int indexOfMinNumber) {
        if (placeIndex < inputArray.length) {
            if (iterationIndex < inputArray.length) {
                if (inputArray[iterationIndex] < inputArray[indexOfMinNumber]) {
                    indexOfMinNumber = iterationIndex;
                    selectionSortRecursionImplement(inputArray, placeIndex, ++iterationIndex, indexOfMinNumber);
                } else {
                    selectionSortRecursionImplement(inputArray, placeIndex, ++iterationIndex, indexOfMinNumber);
                }
            }
            else if (iterationIndex == inputArray.length){
                int minNumber = inputArray[indexOfMinNumber];
                inputArray[indexOfMinNumber] = inputArray[placeIndex];
                inputArray[placeIndex] = minNumber;
                selectionSortRecursionImplement(inputArray,++placeIndex,(placeIndex + 1),placeIndex);
            }
        }
        return inputArray;
    }
}
