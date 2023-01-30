package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 6, -99, 8, 45, -67, 2, 8, 13, 12, 99, 29};
        binarySearchArray(-99, nums);
    }
    public static void binarySearchArray(int searchNumber, int[] array){
        int[] newArray = new int[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        int[] sortedArray = BubbleSort.bubbleSortForLoop(array);
        int minValue = sortedArray[0];
        int maxValue = sortedArray[sortedArray.length-1];
        if ((searchNumber < minValue) || (searchNumber > maxValue)){
            System.out.println("Search Number isn't inside this array..");
        }
        else {
            int indexOfSearchNumber = sortedArray.length;
            int maxIndex = sortedArray.length;
            int minIndex = -1;
            while (true){
                int midIndex = (maxIndex + minIndex) / 2;
                if (sortedArray[midIndex] == searchNumber){
                    indexOfSearchNumber = midIndex;
                    for (int i = 0; i < newArray.length; i++) {
                        if (sortedArray[indexOfSearchNumber] == newArray[i]){
                            System.out.println("Index is 1: " + i);
                            break;
                        }
                    }
                }
                else {
                    if (searchNumber < sortedArray[midIndex]){
                        maxIndex = midIndex;
                    }
                    else if(searchNumber > sortedArray[midIndex]){
                        minIndex = midIndex;
                    }
                }
                if (indexOfSearchNumber < sortedArray.length){
                    break;
                }
                if (maxIndex - minIndex == 1){
                    System.out.println("Search Number isn't inside this array...");
                    break;
                }
            }
        }
    }
}
