package lk.ijse.dep10.regexp;

import java.util.Arrays;
import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        String someText = "My nic is: 963601999V and Her nic is: 971253697v";

        String someText1 = someText.replaceFirst("\\d{9}[Vv]","123");
        System.out.println(someText1);

        String someText2 = someText.replaceAll("\\d{9}[Vv]","1234");
        System.out.println(someText2);

        String newText = "I want to split these words into an array";
        String[] split = newText.split("\\b");
        System.out.println(Arrays.toString(split));
    }
    private static boolean isValidNIC(String input) {
        return false;
    }
}
