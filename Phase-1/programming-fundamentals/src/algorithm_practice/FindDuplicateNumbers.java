package algorithm_practice;

import java.util.ArrayList;
import java.util.Scanner;

public class FindDuplicateNumbers {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter a number sequence: ");
        String input = scanner.nextLine().trim();
        String[] inputNumbers = input.split(",");
        int validateNumber = 0;
        for (int i = 0; i < inputNumbers.length; i++) {
            if (!isDigits(inputNumbers[i].trim())){
                validateNumber += 1;
            }
        }
        if (validateNumber > 0){
            System.err.println("Input sequence isn't a number sequence");
        }
        else if (validateNumber == 0){
            CLITable.printTable(new String[]{"Number","Count"},findDuplicateNumbers(input));
        }
    }
    public static String[][] findDuplicateNumbers(String inputString){
        String[] inputNumbers = inputString.split(",");
        for (int i = 0; i < inputNumbers.length; i++) {
            inputNumbers[i] = inputNumbers[i].trim();
        }
        ArrayList duplicateNumbers = new ArrayList<>();
        ArrayList duplicateCount = new ArrayList<>();
        for (int i = 0; i < inputNumbers.length; i++) {
            int count = 1;
            for (int j = 0; j < inputNumbers.length; j++) {
                if (i == j) continue;
                else {
                    if (inputNumbers[i].trim().equals(inputNumbers[j].trim())){
                        count += 1;
                    }
                }
            }
            if (count > 1 && !duplicateNumbers.contains(inputNumbers[i])){
                duplicateNumbers.add(inputNumbers[i]);
                duplicateCount.add(count);
            }
        }
        String[][] numbersAndCount = new String[duplicateNumbers.size()][2];
        for (int i = 0; i < numbersAndCount.length; i++) {
            numbersAndCount[i][0] = duplicateNumbers.get(i).toString();
            numbersAndCount[i][1] = duplicateCount.get(i).toString();
        }
        return numbersAndCount;
    }
    public static boolean isDigits(String input){
        boolean isDigit = true;
        char[] inputChars = input.toCharArray();
        for (int i = 0; i < inputChars.length; i++) {
            if (inputChars[i] == '-')continue;
            else if (!Character.isDigit(inputChars[i])){
                isDigit = false;
            }
        }
        return isDigit;
    }
}
