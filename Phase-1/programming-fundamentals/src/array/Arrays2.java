package array;

public class Arrays2 {
    public static void main(String[] args) {
        int[] nums;
        nums = new int[] {10, 20, 30}; //creating an array when defining array separately

        int[] nums2;
        nums2 = new int[5];
        System.out.println(nums2[0]);

        String[] names;
        names = new String[5];
        System.out.println(names[0]);
        System.out.println(names[1]);

        String[] addresses = new String[]{"Kurunegala", "Colombo", "Dambulla"}; // another method to create an array // var keyword can be used // var addresses = new String[]{"Kurunegala", "Colombo", "Dambulla"};

        String[] friend = new String[3]; //another method // var keyword can be used //var friend = new String[3];

        //var keyword can be used, when type of the variable can be detected by considering the code
    }
}
