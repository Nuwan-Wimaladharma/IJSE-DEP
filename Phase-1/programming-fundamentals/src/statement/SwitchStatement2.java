package statement;

import java.util.Scanner;

public class SwitchStatement2 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter the month: ");
        String month = scanner.next().toUpperCase();

        switch (month){
            case "JANUARY": case "JAN": case "1":
            case "MARCH": case "MAR": case "3":
            case "MAY": case "5":
            case "JULY": case "JUL": case "7":
            case "AUGUST": case "AUG": case "8":
            case "OCTOBER": case "OCT": case "10":
            case "DECEMBER": case "DEC": case "12":
                System.out.println("31");
                break;

            case "FEBRUARY": case "FEB": case "2":
                System.out.println("28");
                break;

            case "APRIL": case "APR": case "4":
            case "JUNE": case "JUN": case "6":
            case "SEPTEMBER": case "SEP": case "9":
            case "NOVEMBER": case "NOV": case "11":
                System.out.println("30");
                break;

            default:
                System.out.println("Invalid Input");
        }
    }
}
