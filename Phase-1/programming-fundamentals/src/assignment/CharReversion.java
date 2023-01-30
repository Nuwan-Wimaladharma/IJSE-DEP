package assignment;

import java.util.Arrays;

public class CharReversion {
    public static void main(String[] args) {
        String something = "Some text";
        System.out.println(Arrays.toString(reverseString(something)));
        int[] intArray = reverseString(something);
        char[] charArray = new char[intArray.length];
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) intArray[i];
        }
        System.out.println(Arrays.toString(charArray));
    }
    public static int[] reverseString(String text){
        char[] chars = text.toCharArray();
        int[] intArray = new int[chars.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int) chars[i];
        }
        for (int i = 0; i < intArray.length/2; i++) {
            int selectedInt = intArray[i];
            intArray[i] = intArray[intArray.length-1-i];
            intArray[intArray.length-1-i] = selectedInt;
        }
        return intArray;
    }
}
