package algorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{69, 67, 8, 7, 6, 5, 4, 3, 2, 1, 0, -4};
        //System.out.println(Arrays.toString(bubbleSortForLoop(nums)));

        int k = 0;
        do {
            int i = 0;
            do {
                if (nums[i] > nums[i+1]){
                    var temp = nums[i+1];
                    nums[i+1] = nums[i];
                    nums[i] = temp;
                }
            }while (++i < nums.length-1-k);
        } while (++k < nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    public static int[] bubbleSortForLoop(int[] inputArray){
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
//    public static int[] bubbleSortWhileLoop(int[] inputArray){
//
//        return inputArray;
//    }
}
