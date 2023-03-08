package lk.ijse.dep10;

import java.util.Calendar;
import java.util.Date;

public class UtilDate {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1);  //gives date time at the execution moment

        Calendar calendar = Calendar.getInstance();

        calendar.clear(); //set the date and time to the day when unix era started (1970 jan 01 00:00)
        calendar.set(2020,0,1);
        //calendar.set(2020,0,1,0,0,0);  //set the date as your preference

        Date d2 = calendar.getTime();
        System.out.println(d2);  //gives date time at the execution moment

        int year = calendar.get(Calendar.YEAR);
        System.out.println("Year: " + year); //gives year/month/hour/minute when the time creating the calendar instance

        int month = calendar.get(Calendar.MONTH);
        System.out.println("Month: " + month);

        int date = calendar.get(Calendar.DATE);
        System.out.println("Date: " + date);

        int hour = calendar.get(Calendar.HOUR);
        System.out.println("Hour: " + hour);

        int minute = calendar.get(Calendar.MINUTE);
        System.out.println("Minute: " + minute);

        int second = calendar.get(Calendar.SECOND);
        System.out.println("Second: " + second);

        int milliSecond = calendar.get(Calendar.MILLISECOND);
        System.out.println("Milli second: " + milliSecond);
    }
}
