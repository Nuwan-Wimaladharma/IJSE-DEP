package statement.demos;

import java.util.Arrays;
import java.util.Scanner;

public class DoDemo {
    public static void main(String[] args) {
//        var scanner = new Scanner(System.in);
//        int input = 0;
        while (true){
            var scanner = new Scanner(System.in);
            System.out.print("Input a positive integer: ");
            String input = scanner.nextLine().trim();
            char[] inputArray = input.toCharArray();
            int checkInput = 0;
            if (inputArray[0] == '-'){
                int i = 1;
                while (i < inputArray.length){
                    if (!Character.isDigit(inputArray[i])){
                        checkInput += 1;
                    }
                    i++;
                }
            }
            else if (inputArray[0] != '-'){
                int i = 0;
                while (i < inputArray.length){
                    if (!Character.isDigit(inputArray[i])){
                        checkInput += 1;
                    }
                    i++;
                }
            }

            if (checkInput == 0){
                int inputNumber = Integer.parseInt(input);
                if (inputNumber > 0){
                    System.out.println(inputNumber);
                    break;
                }
                else {
                    System.out.println("Invalid input. Please input again...!");
                    continue;
                }
            }
            else {
                System.out.println("Invalid input. Please input again...!");
                continue;
            }
        }

//        do {
//            System.out.print("Enter positive number: ");
//            input = scanner.nextInt();
//            if (input <= 0) System.out.println("Invalid Input");
//        } while (input <= 0);
//        System.out.println("Number: " + input);
    }
}
