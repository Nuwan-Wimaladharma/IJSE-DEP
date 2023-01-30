package algorithm_practice;

import java.util.ArrayList;
import java.util.Scanner;

public class FindDuplicateChars {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Input anything you want: ");
        String input = scanner.nextLine().trim();
        CLITable.printTable(new String[]{"Character", "Count"},findDuplicateChars(input));
    }
    public static String[][] findDuplicateChars(String inputString){
        char[] charactersArray = inputString.toCharArray();
        String charString = "";
        ArrayList countList = new ArrayList<>();
        for (int i = 0; i < charactersArray.length; i++) {
            int count = 1;
            for (int j = 0; j < charactersArray.length; j++) {
                if (i == j) continue;
                else {
                    if (charactersArray[i] == ' ') continue;
                    else {
                        if (charactersArray[i] == charactersArray[j]){
                            count += 1;
                        }
                    }
                }
            }
            if (count > 1 && !charString.contains(String.valueOf(charactersArray[i]))){
                charString += charactersArray[i];
                countList.add(count);
            }
        }
        String[][] charsAndCount = new String[charString.length()][2];
        for (int i = 0; i < charsAndCount.length; i++) {
            charsAndCount[i][0] = String.valueOf(charString.charAt(i));
            charsAndCount[i][1] = countList.get(i).toString();
        }
        return charsAndCount;
    }
}
