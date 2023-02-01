package method;

import java.util.ArrayList;
import java.util.Scanner;
import miscelaneous.TableDemo;

public class CountDuplicates {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Input anything you want: ");
        String input = scanner.nextLine().strip();
        TableDemo.printTable(new String[]{"Character","Count"},findDuplicates(input));
    }
    public static String[][] findDuplicates (String inputString){
        String duplicateChar = "";
        ArrayList duplicateCountNumber = new ArrayList<>();
        char[] inputChar = inputString.toCharArray();
        for (int i = 0; i < inputChar.length; i++) {
            int count = 1;
            if (inputChar[i] == ' '){
                continue;
            }
            else {
                for (int j = 0; j < inputChar.length; j++) {
                    if (i == j){
                        continue;
                    }
                    else {
                        if (inputChar[i] == inputChar[j]){
                            count += 1;
                        }
                    }
                }
            }
            if (count > 1 && !duplicateChar.contains(Character.toString(inputChar[i]))){
                duplicateChar += inputChar[i];
                duplicateCountNumber.add(count);
            }

        }
        String[][] duplicateArray = new String[duplicateChar.length()][2];
        for (int i = 0; i < duplicateArray.length; i++) {
            duplicateArray[i][0] = Character.toString(duplicateChar.charAt(i));
            duplicateArray[i][1] = duplicateCountNumber.get(i).toString();
        }
        return duplicateArray;
    }
}
