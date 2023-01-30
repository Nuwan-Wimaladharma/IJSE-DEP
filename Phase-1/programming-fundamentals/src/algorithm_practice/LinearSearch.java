package algorithm_practice;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {1, 4, 7, 10, 17, -9, 13, 21};
        //findNumberForLoop(nums, 15);
        //findNumberWhileLoop(nums, 16);
        //findNumberForEachLoop(nums,7);
        //findNumberDoWhileLoop(nums, 17);
        findNumberRecursion(nums, 36, nums.length);
    }
    public static void findNumberForLoop(int[] array, int searchNumber){
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchNumber){
                index = i;
            }
        }
        if (index != -1){
            System.out.println("Index is: " + index);
        }
        else {
            System.err.println("The number you search isn't in the array");
        }
    }
    public static void findNumberWhileLoop(int[] array, int searchNumber){
        int index = -1;
        int i = 0;
        while (i < array.length){
            if (array[i] == searchNumber){
                index = i;
            }
            i++;
        }
        if (index != -1){
            System.out.println("Index is: " + index);
        }
        else{
            System.err.println("The number you search isn't in the array");
        }
    }
    public static void findNumberForEachLoop(int[] array, int searchNumber){
        int index = -1;
        int i = 0;
        for (int numbers: array){
            if (numbers == searchNumber){
                index = i;
                break;
            }
            i++;
        }
        if (index != -1){
            System.out.println("Index is: " + index);
        }
        else{
            System.err.println("The number you search isn't in the array");
        }
    }
    public static void findNumberDoWhileLoop(int[] array, int searchNumber){
        int index = -1;
        int i = 0;
        do {
            if (array[i] == searchNumber){
                index = i;
            }
            i++;
        }while (i < array.length);
        if (index != -1){
            System.out.println("Index is: " + index);
        }
        else{
            System.err.println("The number you search isn't in the array");
        }
    }
    public static void findNumberRecursion(int[] array, int searchNumber, int arrayLength){
        int index = -1;
        if (arrayLength-1 >= 0){
            if (array[arrayLength-1] == searchNumber){
                index = arrayLength-1;
                System.out.println("Index is: " + index);
            }
            else {
                findNumberRecursion(array, searchNumber, --arrayLength);
            }
        }
        else {
            System.err.println("The number you search isn't in the array");
        }
    }
}
