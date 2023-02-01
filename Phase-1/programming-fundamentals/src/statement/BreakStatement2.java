package statement;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class BreakStatement2 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter the day: ");
        String day = scanner.nextLine().trim().toUpperCase();

        switch (day){
            case "MONDAY":{
                System.out.println("You entered Monday");
                break;
            }
            case "TUESDAY":
                System.out.println("You entered Tuesday");
            case "WEDNESDAY":
                System.out.println("You entered Wednesday");
                break;
            case "THURSDAY":
                System.out.println("You entered Thursday");
                break;
            case "FRIDAY":
                System.out.println("You entered Friday");
                break;
            case "SATURDAY":
                System.out.println("You entered Saturday");
                break;
            case "SUNDAY":
                System.out.println("You entered Sunday");
                break;
            default:
                System.out.println("Invalid Input");
        }
        System.out.println("After the switch statement");

    }
}
