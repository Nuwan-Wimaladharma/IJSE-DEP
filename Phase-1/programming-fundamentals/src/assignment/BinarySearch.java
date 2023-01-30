package assignment;

import algorithms.BubbleSort;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 5, 7, 10, 15, 22};
        System.out.println(binarySearchArray(nums,7));
    }
    public static boolean binarySearchArray(int[] array, int searchNumber){
        boolean isIn = false;
        int minValue = array[0];
        int maxValue = array[array.length-1];
        if ((searchNumber < minValue) || (searchNumber > maxValue)){
            return isIn;
        }
        else {
            int indexOfSearchNumber = array.length;
            int maxIndex = array.length;
            int minIndex = -1;
            while (true){
                int midIndex = (maxIndex + minIndex) / 2;
                if (array[midIndex] == searchNumber){
                    indexOfSearchNumber = midIndex;
                    isIn = true;
                }
                else {
                    if (searchNumber < array[midIndex]){
                        maxIndex = midIndex;
                    }
                    else if(searchNumber > array[midIndex]){
                        minIndex = midIndex;
                    }
                }
                if (indexOfSearchNumber < array.length){
                    break;
                }
                if (maxIndex - minIndex == 1){
                    return isIn;
                }
            }
        }
        return isIn;
    }
}
