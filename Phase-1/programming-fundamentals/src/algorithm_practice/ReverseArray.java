package algorithm_practice;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 6, 7, 5, 9, 13, 67, 33, 49, 122, 13, 56, 889, -96};
        //System.out.println(Arrays.toString(reverseArrayForLoop(nums)));
        //System.out.println(Arrays.toString(reverseArrayWhileLoop(nums)));
        //System.out.println(Arrays.toString(reverseArrayDoWhileLoop(nums)));
        //System.out.println(Arrays.toString(reverseArrayForEachLoop(nums)));
        System.out.println(Arrays.toString(reverseArrayRecursion(nums)));
    }
    public static int[] reverseArrayForLoop(int[] array){
        for (int i = 0; i < array.length/2; i++) {
            int selectedElement = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = selectedElement;
        }
        return array;
    }
    public static int[] reverseArrayWhileLoop(int[] array){
        int i = 0;
        while (i < array.length / 2){
            int selectedElement = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = selectedElement;
            i++;
        }
        return array;
    }
    public static int[] reverseArrayDoWhileLoop(int[] array){
        int i = 0;
        do {
            int selectedInt = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = selectedInt;
            i++;
        }while (i < array.length/2);
        return array;
    }
    public static int[] reverseArrayForEachLoop(int[] array){
        int i = 0;
        for (int numbers : array){
            int selectedInt = numbers;
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = selectedInt;
            i++;
            if (i > (array.length/2)) break;
        }
        return array;
    }
    public static int[] reverseArrayRecursion(int[] array){
        reverseArrayRecursionImplement(array, 0);
        return array;
    }
    public static int[] reverseArrayRecursionImplement(int[] array,int startingIndex){
        if (startingIndex < array.length / 2){
            int selectedInt = array[startingIndex];
            array[startingIndex] = array[array.length - 1 - startingIndex];
            array[array.length - 1 - startingIndex] = selectedInt;
            reverseArrayRecursionImplement(array,++startingIndex);
        }
        return array;
    }
}
