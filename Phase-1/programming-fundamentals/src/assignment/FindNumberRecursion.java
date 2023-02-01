package assignment;

public class FindNumberRecursion {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 56, 76, 344, 78, 0, -5, -6, 56, 9, 90};
        findNumberRecursion(nums, 3, nums.length);
        findNumberRecursion(nums, 2, nums.length);
        findNumberRecursion(nums, 90, nums.length);
        findNumberRecursion(nums, 0, nums.length);
        findNumberRecursion(nums, -5, nums.length);
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
            System.err.println("Not found");
        }
    }
}
