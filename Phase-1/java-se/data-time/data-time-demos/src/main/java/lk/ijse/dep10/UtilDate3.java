package lk.ijse.dep10;

import java.util.Calendar;
import java.util.Date;

public class UtilDate3 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        cal.clear();
        cal.set(2020,3,5);
        Date d1 = cal.getTime();

        cal.clear();
        cal.set(2020,3,8);
        Date d2 = cal.getTime();

        cal.clear();
        cal.set(2019,11,8);
        Date d3 = cal.getTime();

        cal.clear();
        cal.set(2020,3,5);
        Date d4 = cal.getTime();

        System.out.println(d1.before(d2)); //true
        System.out.println(d1.after(d2)); //false
        System.out.println(d3.before(d1)); // true
        System.out.println(d3 == d2); // false
        System.out.println(d1 == d4); //false
        System.out.println(d1.equals(d4)); //true
    }
}
