package lk.ijse.dep10;

import java.util.Calendar;

public class UtilDate5 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(2023,2,7);
        System.out.println(cal.get(Calendar.YEAR));
        cal.add(Calendar.MONTH,-3);
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.getTime());

        Calendar cal2 = Calendar.getInstance();
        System.out.println(cal2.getTime());

        cal2.setTime(cal.getTime());
        System.out.println(cal2.getTime());
    }
}
