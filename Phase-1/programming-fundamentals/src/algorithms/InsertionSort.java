package algorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{-7, -10, 3, 20, 2, 2, 3, 22};
        //insertionSort(nums);

//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] < nums[i-1]){
//                var insert = nums[i];
//                for (int k = 0; k < i; k++) {
//                    if (insert < nums[k]){
//                        for (int j = i; j > k; j--) {
//                            nums[j] = nums[j-1];
//                        }
//                        nums[k] = insert;
//                        break;
//                    }
//                }
//            }
//        }
//        System.out.println(Arrays.toString(nums));
        insertionSort(nums);
    }
    public static void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int selectedInt = array[i];
            int j = i - 1;
            while (j >= 0 && selectedInt < array[j]){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = selectedInt;
        }
        System.out.println(Arrays.toString(array));
    }
}
