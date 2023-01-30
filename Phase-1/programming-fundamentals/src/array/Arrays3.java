package array;

public class Arrays3 {
    public static void main(String[] args) {
        int[][] array2d = new int[3][];
        int[] nums = new int[3];
        array2d[1] = new int[]{10, 20, 30};
        System.out.println(array2d[1]); //prints an address of a memory location
        System.out.println(array2d[1][0]);

        array2d[2] = new int[0];
        System.out.println(array2d[2]); //prints an address of a memory location

        array2d[0] = nums;
        System.out.println(nums[2]);
        array2d[0][2] = 30;
        System.out.println(nums[2]);
    }
}
