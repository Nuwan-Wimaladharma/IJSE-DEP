package lk.ijse.dep10;

import java.nio.channels.CancelledKeyException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AgeCounter {
    public static void main(String[] args) {
        Date bd;
        while (true){
            System.out.print("Enter your birthday (yyyy-MM-dd): ");
            Scanner scanner = new Scanner(System.in);
            String day1 = scanner.next();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                bd = sdf1.parse(day1);
            }
            catch (ParseException e){
                System.out.println("Incorrect. Please Input day in correct format");
                continue;
            }
            Calendar currentTime = Calendar.getInstance();
            if (bd.after(currentTime.getTime())){
                System.out.println("Invalid input. Please input a valid birthday");
                continue;
            }
            if (bd.before(currentTime.getTime())){
                break;
            }
        }

        //Calendar currentTime2 = Calendar.getInstance();
        //int currentYear = currentTime2.get(Calendar.YEAR);
        //int currentMonth = currentTime2.get(Calendar.MONTH);
        //int currentDay = currentTime2.get(Calendar.DATE);

        Calendar bdDetails = Calendar.getInstance();
        bdDetails.setTime(bd);
        int bdYear = bdDetails.get(Calendar.YEAR);
        int bdMonth = bdDetails.get(Calendar.MONTH);
        int bdDay = bdDetails.get(Calendar.DATE);

        int years = 0;
        int month = 0;
        int days = 0;

        int i = 1;
        while (true){
            Calendar currentTime2 = Calendar.getInstance();
            currentTime2.add(Calendar.YEAR,-i);
            if (currentTime2.get(Calendar.YEAR) == bdYear){
                years = i;
                break;
            }
            i++;
        }
        int j = 1;
        while (true){
            Calendar currentTime2 = Calendar.getInstance();
            currentTime2.add(Calendar.MONTH,-j);
            if (currentTime2.get(Calendar.YEAR) == bdYear){
                month = j;
                break;
            }
            j++;
        }
        int k = 1;
        while (true){
            Calendar currentTime2 = Calendar.getInstance();
            currentTime2.add(Calendar.DATE,-k);
            if (currentTime2.get(Calendar.YEAR) == bdYear){
                days = k;
                break;
            }
            k++;
        }
        int[] normalYear = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] leapYear = {31,29,31,30,31,30,31,31,30,31,30,31};
        System.out.println(years);
        System.out.println(month);
        System.out.println(days);
//        //System.out.println(month / 12);
//        //System.out.println(month % 12);
//        System.out.println(days/365);
//
//        System.out.println(days / (365 * 12));
//        System.out.println(days % (365 * 12));
    }
    private static boolean isLeapYear(int year){
        if (year % 400 == 0) return true;
        else if (year % 100 == 0) return false;
        else if (year % 4 == 0) return true;
        return false;
    }
}
