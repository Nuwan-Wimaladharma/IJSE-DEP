package statement;

import java.util.Scanner;

public class IfStatement {
    public static void main(String[] args) {
        //syntax
        //if (boolean expression){
        // }

        //if (boolean expression){
        //if boolean expression becomes true ---> statement
        // }

        var scanner = new Scanner(System.in);
        System.out.print("Enter an integer greater than 25: ");
        int number = scanner.nextInt();
//        if (number > 25) System.out.println("Valid"); //if there is only one statement under if condition
        if (number > 25) System.out.println("Valid");
        else System.out.println("Invalid");
    }
}
