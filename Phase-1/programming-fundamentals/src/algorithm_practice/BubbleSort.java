package algorithm_practice;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{13, 4, 0, -4, 8, 7, 12, -98, -2, 13, 44, 98};
        //System.out.println(Arrays.toString(bubbleSortForLoopBubblingMaximum(nums)));
        //System.out.println(Arrays.toString(bubbleSortForLoopBubblingMinimum(nums)));
        //System.out.println(Arrays.toString(bubbleSortWhileLoopBubblingMaximum(nums)));
        //System.out.println(Arrays.toString(bubbleSortWhileLoopBubblingMinimum(nums)));
        //System.out.println(Arrays.toString(bubbleSortDoWhileLoopBubblingMaximum(nums)));
        //System.out.println(Arrays.toString(bubbleSortDoWhileLoopBubblingMinimum(nums)));
        //System.out.println(Arrays.toString(bubbleSortRecursionBubblingMaximum(nums)));
        System.out.println(Arrays.toString(bubbleSortRecursionBubblingMinimum(nums)));
    }
    public static int[] bubbleSortForLoopBubblingMaximum(int[] inputArray){
        for (int i = inputArray.length-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                int maxNumber = inputArray[j+1];
                if (inputArray[j] > maxNumber){
                    inputArray[j+1] = inputArray[j];
                    inputArray[j] = maxNumber;
                }
            }
        }
        return inputArray;
    }
    public static int[] bubbleSortForLoopBubblingMinimum(int[] inputArray){
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = inputArray.length-1; j > i; j--) {
                int minNumber = inputArray[j-1];
                if (inputArray[j] < minNumber){
                    inputArray[j-1] = inputArray[j];
                    inputArray[j] = minNumber;
                }
            }
        }
        return inputArray;
    }
    public static int[] bubbleSortWhileLoopBubblingMaximum(int[] inputArray){
        int i = inputArray.length-1;
        while (i >= 0){
            int j = 0;
            while (j < i){
                int maxNumber = inputArray[j+1];
                if (inputArray[j] > maxNumber){
                    inputArray[j+1] = inputArray[j];
                    inputArray[j] = maxNumber;
                }
                j++;
            }
            i--;
        }
        return inputArray;
    }
    public static int[] bubbleSortWhileLoopBubblingMinimum(int[] inputArray){
        int i = 0;
        while (i < inputArray.length){
            int j = inputArray.length-1;
            while (j > i){
                int minNumber = inputArray[j-1];
                if (inputArray[j] < minNumber){
                    inputArray[j-1] = inputArray[j];
                    inputArray[j] = minNumber;
                }
                j--;
            }
            i++;
        }
        return inputArray;
    }
    public static int[] bubbleSortDoWhileLoopBubblingMaximum(int[] inputArray){
        int i = inputArray.length-1;
        do {
            int j = 0;
            do {
                int maxNumber = inputArray[j+1];
                if (inputArray[j] > maxNumber){
                    inputArray[j+1] = inputArray[j];
                    inputArray[j] = maxNumber;
                }
                j++;
            }while (j < i);
            i--;
        }while (i >= 0);
        return inputArray;
    }
    public static int[] bubbleSortDoWhileLoopBubblingMinimum(int[] inputArray){
        int i = 0;
        do {
            int j = inputArray.length-1;
            do {
                int minNumber = inputArray[j-1];
                if (inputArray[j] < minNumber){
                    inputArray[j-1] = inputArray[j];
                    inputArray[j] = minNumber;
                }
                j--;
            }while (j > i);
            i++;
        }while (i < inputArray.length);
        return inputArray;
    }
    public static int[] bubbleSortRecursionBubblingMaximum(int[] inputArray){
        bubbleSortRecursionBubblingMaximumImplement(inputArray, inputArray.length-1,0);
        return inputArray;
    }
    public static int[] bubbleSortRecursionBubblingMaximumImplement(int[] inputArray, int outerIndex, int innerIndex){
        if (outerIndex >= 0){
            if (innerIndex < outerIndex){
                int maxNumber = inputArray[innerIndex + 1];
                if (inputArray[innerIndex] > maxNumber){
                    inputArray[innerIndex + 1] = inputArray[innerIndex];
                    inputArray[innerIndex] = maxNumber;
                    bubbleSortRecursionBubblingMaximumImplement(inputArray,outerIndex, ++innerIndex);
                }
                else {
                    bubbleSortRecursionBubblingMaximumImplement(inputArray,outerIndex, ++innerIndex);
                }
            }
            else {
                bubbleSortRecursionBubblingMaximumImplement(inputArray,--outerIndex, 0);
            }
        }
        return inputArray;
    }
    public static int[] bubbleSortRecursionBubblingMinimum(int[] inputArray){
        bubbleSortRecursionBubblingMinimumImplement(inputArray, 0,inputArray.length-1);
        return inputArray;
    }
    public static int[] bubbleSortRecursionBubblingMinimumImplement(int[] inputArray, int outerIndex, int innerIndex){
        if (outerIndex < inputArray.length){
            if (innerIndex > outerIndex){
                int minNumber = inputArray[innerIndex - 1];
                if (inputArray[innerIndex] < minNumber){
                    inputArray[innerIndex - 1] = inputArray[innerIndex];
                    inputArray[innerIndex] = minNumber;
                    bubbleSortRecursionBubblingMinimumImplement(inputArray,outerIndex, --innerIndex);
                }
                else {
                    bubbleSortRecursionBubblingMinimumImplement(inputArray,outerIndex, --innerIndex);
                }
            }
            else {
                bubbleSortRecursionBubblingMinimumImplement(inputArray,++outerIndex, inputArray.length-1);
            }
        }
        return inputArray;
    }
}