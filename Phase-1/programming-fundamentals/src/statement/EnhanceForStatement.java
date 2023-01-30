package statement;

public class EnhanceForStatement {
    public static void main(String[] args) {
        var nums = new int[]{10, 20, 30, 40, 50};
//        for (int i = 0; i < nums.length; i++){
//            System.out.println(nums[i]);
//        }
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        System.out.println("Sum is: " + sum);
    }
}
