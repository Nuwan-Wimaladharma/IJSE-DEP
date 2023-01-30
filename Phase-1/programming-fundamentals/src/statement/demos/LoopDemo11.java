package statement.demos;

import java.util.Arrays;
public class LoopDemo11 {
    public static void main(String[] args) {
        var nums = new int[]{20, 12, 25, -85, 0, 12, 25, 30, 12};
        int b = 0;
        while (b < nums.length) {
            int minIndex = b;
            int a = b+1;
            while (a < nums.length){
                if (nums[a] < nums[minIndex]){
                    minIndex = a;
                }
                a++;
            }
            int minNumber = nums[minIndex];
            nums[minIndex] = nums[b];
            nums[b] = minNumber;
            b++;
        }
        System.out.println(Arrays.toString(nums));
    }
}
