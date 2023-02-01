package assignment;

import java.util.Arrays;

public class FindMinMax {
    public static void main(String[] args) {
        int[] nums = new int[]{1, -4, 13, 21, 0, 78, 99, 29, 34, 60};
        int[] nums2 = new int[]{0, 4, 7, 9, 13, 32, 45, 77, 121};
        System.out.println(Arrays.toString(findMinMax(nums)));
        System.out.println(Arrays.toString(findMinMax(nums2)));
    }
    public static int[] findMinMax(int[] array){
        int minValue = 0;
        int i = 0;
        do {
            if (array[i] < minValue){
                minValue = array[i];
            }
            i++;
        } while (i < array.length);
        int maxValue = 0;
        int j = 0;
        do {
            if (array[j] > maxValue){
                maxValue = array[j];
            }
            j++;
        } while (j < array.length);
        int[] answerArray = new int[2];
        answerArray[0] = minValue;
        answerArray[1] = maxValue;
        return answerArray;
    }
}
