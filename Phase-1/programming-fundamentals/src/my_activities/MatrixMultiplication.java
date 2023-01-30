package my_activities;

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        System.out.println("Multiplication of two matrices");
        System.out.println();
        int numberOfRawsMatA = 0;
        int numberOfColumnsMatA = 0;
        int numberOfRawsMatB = 0;
        int numberOfColumnsMatB = 0;
        var scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Number of raws of Matrix A: ");
            String numberOfRaws = scanner.nextLine().trim();
            if (isValidMatrixDimensionInput(numberOfRaws)){
                numberOfRawsMatA = Integer.parseInt(numberOfRaws);
                break;
            }
            else System.out.println("\u001b[31mInvalid Input. Please enter an integer...\u001b[0m");
        }
        while (true) {
            System.out.print("Number of columns of Matrix A: ");
            String numberOfColumns = scanner.nextLine().trim();
            if (isValidMatrixDimensionInput(numberOfColumns)){
                numberOfColumnsMatA = Integer.parseInt(numberOfColumns);
                break;
            }
            else System.out.println("\u001b[31mInvalid Input. Please enter an integer...\u001b[0m");
        }
        System.out.println();
        while (true) {
            System.out.print("Number of raws of Matrix B: ");
            String numberOfRaws = scanner.nextLine().trim();
            if (isValidMatrixDimensionInput(numberOfRaws)){
                numberOfRawsMatB = Integer.parseInt(numberOfRaws);
                break;
            }
            else System.out.println("\u001b[31mInvalid Input. Please enter an integer...\u001b[0m");
        }
        while (true) {
            System.out.print("Number of columns of Matrix B: ");
            String numberOfColumns = scanner.nextLine().trim();
            if (isValidMatrixDimensionInput(numberOfColumns)){
                numberOfColumnsMatB = Integer.parseInt(numberOfColumns);
                break;
            }
            else System.out.println("\u001b[31mInvalid Input. Please enter an integer...\u001b[0m");
        }
    }
    public static boolean isValidMatrixDimensionInput(String input){
        boolean isValid = true;
        char[] inputChars = input.toCharArray();
        for (int i = 0; i < inputChars.length; i++) {
            if (!Character.isDigit(inputChars[i])){
                isValid = false;
            }
        }
        return isValid;
    }
}
