package statement;

import java.util.Scanner;

public class SwitchStatement3 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter the month: ");
        String month = scanner.next().toUpperCase();

        int days = 0;
        switch (month) {
            case "DECEMBER": case "DEC": case "12":
                days += 30;

            case "NOVEMBER": case "NOV": case "11":
                days += 31;

            case "OCTOBER": case "OCT": case "10":
                days += 30;

            case "SEPTEMBER": case "SEP": case "9":
                days += 31;

            case "AUGUST": case "AUG": case "8":
                days += 31;

            case "JULY": case "JUL": case "7":
                days += 30;

            case "JUNE": case "JUN": case "6":
                days += 31;

            case "MAY":  case "5":
                days += 30;

            case "APRIL": case "APR": case "4":
                days += 31;

            case "MARCH": case "MAR": case "3":
                days += 28;

            case "FEBRUARY": case "FEB": case "2":
                days += 31;

            case "JANUARY": case "JAN": case "1":
                days += 0;
                break;

            default:
                System.out.println("Invalid Input");

        }
        System.out.println(days);
    }
}
