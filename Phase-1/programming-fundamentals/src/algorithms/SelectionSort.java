package algorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        var nums = new int[] {6,5,2,1,4,3};
//        int i = nums.length-1;
//        while (i >= 0){
//            int maxIndex = i;
//            int j = i-1;
//            while (j >= 0){
//                if (nums[j] > nums[maxIndex]){
//                    maxIndex = j;
//                }
//                j--;
//            }
//            int maxNumber = nums[maxIndex];
//            nums[maxIndex] = nums[i];
//            nums[i] = maxNumber;
//            i--;
//        }
//        System.out.println(array.Arrays.toString(nums));

//        for (int i = nums.length-1; i >= 0; i--){
//            int maxIndex = i;
//            for (int j = i-1; j >= 0; j--){
//                if (nums[j] > nums[maxIndex]){
//                    maxIndex = j;
//                }
//            }
//            int maxNumber = nums[maxIndex];
//            nums[maxIndex] = nums[i];
//            nums[i] = maxNumber;
//        }
//        System.out.println(Arrays.toString(nums));

//        var maxIndex = nums.length - 1;  //7
//        var max = nums[maxIndex];       //20
//
//        var i = 0;
//        while (i < 5){
//            System.out.println(i);
//            i++;
//        }
//
//        System.out.println(array.Arrays.toString(nums));
        System.out.println(Arrays.toString(selectionSortForLoop(nums)));


    }
    public static int[] selectionSortForLoop(int[] inputArray){
        for (int j = 0; j < inputArray.length; j++) {
            int indexOfMinNumber = j;
            for (int i = j+1; i < inputArray.length; i++) {
                if (inputArray[i] < inputArray[indexOfMinNumber]){
                    indexOfMinNumber = i;
                }
            }
            int minNumber = inputArray[indexOfMinNumber];
            inputArray[indexOfMinNumber] = inputArray[j];
            inputArray[j] = minNumber;
        }
        return inputArray;
    }
}
