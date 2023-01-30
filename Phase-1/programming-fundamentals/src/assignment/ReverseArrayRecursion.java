package assignment;

import java.util.Arrays;

public class ReverseArrayRecursion {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 6, 90, 34, 56, 23, 22, 55};
        addArg(nums);
    }
    public static void addArg(int[] array){
        reverseArrayRecursion(array, 0);
    }
    public static void reverseArrayRecursion(int[] array, int index){
        if (index < array.length/2){
            int selectedInt = array[index];
            array[index] = array[array.length-1-index];
            array[array.length-1-index] = selectedInt;
            reverseArrayRecursion(array,++index);
        }
        else {
            System.out.println(Arrays.toString(array));
        }
    }
}
