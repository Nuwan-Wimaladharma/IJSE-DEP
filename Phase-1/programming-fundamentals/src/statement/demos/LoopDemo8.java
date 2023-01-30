package statement.demos;

import java.util.Arrays;

public class LoopDemo8 {
    public static void main(String[] args) {
        var nums = new int[] {10, 20, 30, 40, 50};
        var nums2 = new int[nums.length];
        int i = 0;
        while (i < nums.length){
            nums2[i] = nums[i];
            i++;
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));
    }
}
