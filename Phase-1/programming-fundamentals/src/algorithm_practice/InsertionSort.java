package algorithm_practice;

import java.util.Arrays;

public class InsertionSort { //ToDo
    public static void main(String[] args) {
        int[] nums = new int[]{22, 31, 13, -5, -12, 23, 44, 16, 99, 101, 32, 54, 0, 1, 3, 11};
        insertionSortBinarySearch(nums);
    }
    public static void insertionSortBinarySearch(int[] array){
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
    public static void binarySearch(int[] inputArray, int number){

    }
}
