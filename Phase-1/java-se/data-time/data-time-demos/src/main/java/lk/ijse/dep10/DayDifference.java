package lk.ijse.dep10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DayDifference {
    public static void main(String[] args) {
        Date d1;
        Date d2;
        while (true){
            System.out.print("Enter day 1 (yyyy-MM-dd): ");
            Scanner scanner1 = new Scanner(System.in);
            String day1 = scanner1.next();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                d1 = sdf1.parse(day1);
                break;
            }
            catch (ParseException e){
                System.out.println("Incorrect. Please Input day in correct format");
                continue;
            }
        }
        while (true){
            System.out.print("Enter day 2 (yyyy-MM-dd): ");
            Scanner scanner2 = new Scanner(System.in);
            String day2 = scanner2.next();
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                d2 = sdf2.parse(day2);
            }
            catch (ParseException e){
                System.out.println("Incorrect. Please Input day in correct format");
                continue;
            }
            if (d2.before(d1)){
                System.out.println("Please input a day after the day 1, for day 2");
                continue;
            }
            if (d2.after(d1)){
                break;
            }
        }

        long days = ((d2.getTime() - d1.getTime())/(1000 * 60 * 60 * 24));
        System.out.println("Difference between day 1 and day 2 is " + days + " days");
    }
}
