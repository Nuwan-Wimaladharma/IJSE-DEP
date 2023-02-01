package statement.demos;

import java.util.Arrays;

public class LoopDemo10 {
    public static void main(String[] args) {
        var nums = new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        var nums2 = new int[nums.length];
        int i = nums.length-1;
        while (i >= 0){
            nums2[(nums.length-1) - i] = nums[i];
            i--;
        }
        nums = nums2;
        System.out.println(Arrays.toString(nums));
    }
}
