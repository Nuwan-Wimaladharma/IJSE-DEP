package lk.ijse.dep10.regexp;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String dob;
            do {
                System.out.print("Enter a dob (yyyy-mm-dd): ");
                dob = scanner.nextLine();
            }while (dob.isBlank());
            System.out.println(isValidDOB(dob.strip()));
        }
    }
    private static boolean isValidDOB(String input){
        return input.matches("(19\\d{2}|2\\d{3})-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1])");
//        if (input.length() != 10 || input.charAt(4) != '-' || input.charAt(7) != '-') return false;
//        String year = input.substring(0,4);
//        char[] charYear = year.toCharArray();
//        for (char c : charYear) {
//            if (!Character.isDigit(c)){
//                return false;
//            }
//        }
//        int yearInt = Integer.parseInt(year);
//        if (yearInt < 1900) return false;
//
//        String month = input.substring(5,7);
//        char[] charMonth = month.toCharArray();
//        for (char c : charMonth) {
//            if (!Character.isDigit(c)){
//                return false;
//            }
//        }
//        int monthInt = Integer.parseInt(month);
//        if (monthInt < 1 || monthInt > 12) return false;
//
//        String day = input.substring(8,10);
//        char[] charDay = year.toCharArray();
//        for (char c : charDay) {
//            if (!Character.isDigit(c)){
//                return false;
//            }
//        }
//        int dayInt = Integer.parseInt(day);
//        if (dayInt < 1 || dayInt > 31) return false;
//
//        return true;
    }
}
