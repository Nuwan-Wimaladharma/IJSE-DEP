package assignment;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 0, -2, 23, 19, 13, 12, 44, 99, 345, -12, 16, 4, 3, -19, 36};
        System.out.println(Arrays.toString(selectionSort(nums)));
    }
    public static int[] selectionSort(int[] inputArray){
        int i = inputArray.length-1;
        do {
            int j = i-1;
            int indexOfMaxNumber = i;
            do {
                if (inputArray[j] > inputArray[indexOfMaxNumber]){
                    indexOfMaxNumber = j;
                }
                j--;
            } while (j >= 0);
            int maxNumber = inputArray[indexOfMaxNumber];
            inputArray[indexOfMaxNumber] = inputArray[i];
            inputArray[i] = maxNumber;
            i--;
        } while (i > 0);
        return inputArray;
    }
}
