import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
//        String str1 = "IJSE";
//        String str2 = "ijSe";
//        String str3 = new String("IJSE").intern(); // if value of the created string already in the string phool, refer that same location my the variable
//        System.out.println(str1 == str2); //return true #reason is these two strings are created in variable stack(but value is not there, value is in the heap)
//
//        var scanner = new Scanner(System.in);
//        System.out.print("Enter a name: ");
//        String input = scanner.next();
//        System.out.println(scanner instanceof Scanner);// return true
//
//        System.out.println(input == str1); //returns false
//        System.out.println(input == str2); //returns false
//
//        System.out.println("Output 4 is: " + str1.equals(str2)); //use equals() method to compare two strings
//        System.out.println("Output 5 is " + str1.equalsIgnoreCase(str2)); //use equalsIgnoreCase() to ignore the case of the letters

//        String name = "nuwan";
//        int number = name.charAt(2);
//        System.out.println(number);

        //String newString = number.split(" ");
        //System.out.println(newString);

        int[] nums = new int[]{5,4,3,2,1};
        //System.out.println(Arrays.toString(selectionSortRecursion(nums)));
        ArrayList list = new ArrayList<>();
        list.add(4);
        list.add("Nuwan");
        System.out.println(list);


    }
//    public static void selectionSortRecursion(int[] inputArray){
//        selectionSortRecursionImplement(inputArray, 0, 1);
//    }
//    public static int[] selectionSortRecursionImplement(int[] inputArray, int indexOfMinNumber, int index){
//        if (index < inputArray.length){
//            if (inputArray[index] < inputArray[indexOfMinNumber]){
//                indexOfMinNumber = index;
//                selectionSortRecursionImplement(inputArray,indexOfMinNumber,++index);
//            }
//        }
//    }
}
