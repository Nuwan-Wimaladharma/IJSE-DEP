package assignment;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 0, -23, 12, 2, 3, 33, 2, 9};
        System.out.println(Arrays.toString(bubbleSort(nums)));
    }
    public static int[] bubbleSort(int[] inputArray){
        for (int i = inputArray.length-1; i >= 0 ; i--) {
            for (int j = 0; j < i; j++) {
                int max = inputArray[j+1];
                if (inputArray[j] > max){
                    inputArray[j+1] = inputArray[j];
                    inputArray[j] = max;
                }
            }
        }
        return inputArray;
    }
}
