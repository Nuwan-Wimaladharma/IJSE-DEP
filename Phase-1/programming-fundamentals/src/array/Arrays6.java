package array;

public class Arrays6 {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        int[] nums = {x,y,30,40};
        var nums2 = new int[3][2];
        nums2[1] = nums;
        nums2[nums2.length-1][0] = 50;
        var nums3 = new int [][][]{nums2,{{10,20},{75,85}}};
        System.out.println(nums3[nums2[0].length-1][1][0]);
        nums3[1][0] = new  int[] {85,95};
        nums = nums3[1][1];
        System.out.println(nums[nums.length-1]);
    }
}
