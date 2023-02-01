package statement.demos;

public class LoopDemo12 {
    public static void main(String[] args) {
        var nums = new int[]{10, 25, 30, 0, -25, -4, 15, 20};
        int min = 0;
        int minIndex = 0;
        int max = 0;
        int maxIndex = 0;

//        int a = 0;
//        while (a < nums.length){
//            if (nums[a] < min){
//                min = nums[a];
//                minIndex = a;
//            }
//            if (nums[a] > max){
//                max = nums[a];
//                maxIndex = a;
//            }
//            a++;
//        }
//        System.out.printf("Min value: %s, Min index: %s \n", min, minIndex);
//        System.out.printf("Max value: %s, Max index: %s \n", max, maxIndex);

        for (int i = 0; i < nums.length; i++){
            if (nums[i] < min){
                min = nums[i];
                minIndex = i;
            }
            if (nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        System.out.println("Min value: " + min + "   Min index: " + minIndex);
        System.out.println("Max value: " + max + "   Man index: " + maxIndex);
    }
}
