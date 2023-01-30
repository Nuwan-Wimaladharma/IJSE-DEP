package statement;

import java.util.Scanner;

public class SwitchStatement {
    public static void main(String[] args) {
        String name = "Nuwan";
        var scanner = new Scanner(System.in);
        System.out.print("Enter your grade: ");
        char grade = scanner.nextLine().charAt(0);

//        if (grade == 'A'){
//            System.out.println("A pass");
//        }
//        else if (grade == 'B') {
//            System.out.println("B pass");
//        }
//        else if (grade == 'C') {
//            System.out.println("C pass");
//        }
//        else if (grade == 'S') {
//            System.out.println("S pass");
//        }
//        else if (grade == 'F') {
//            System.out.println("F pass");
//        }
//        else {
//            System.out.println("Invalid Input");
//        }

        switch (grade){
            case 'A':
            case 'a':
                System.out.println("A pass");
                break;

            case 'B':
            case 'b':
                System.out.println("B pass");
                break;

            case 'C':
            case 'c':
                System.out.println("C pass");
                break;

            case 'S':
            case 's':
                System.out.println("S pass");
                break;

            case 'F':
            case 'f':
                System.out.println("F pass");
                break;

            default:
                System.out.println("Invalid Input");  //no need of break for bottom most statement. if default is at the top, break is needed

        }
    }
}
