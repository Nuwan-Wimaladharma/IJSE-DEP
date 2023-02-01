package statement.demos;

import java.util.Arrays;
import java.util.Scanner;

public class LoopsDemo9 {
    public static void main(String[] args) {
        int[] numArray = new int[0];
        while (true) {
            var scanner = new Scanner(System.in);
            System.out.print("Enter a number: ");
            String input = scanner.nextLine();
            if (!input.equals("q")){
                int inputNumber = Integer.parseInt(input);
                int[] newNumArray = new int[numArray.length + 1];
                int a = 0;
                while (a < numArray.length){
                    newNumArray[a] = numArray[a];
                    a++;
                }
                newNumArray[newNumArray.length-1] = inputNumber;
                numArray = newNumArray;
                continue;
            }
            if (input.equals("q")){
                System.out.println(Arrays.toString(numArray));
                break;
            }
        }
    }
}
