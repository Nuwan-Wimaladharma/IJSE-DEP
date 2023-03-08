package lk.ijse.dep10;

import java.time.LocalDate;
import java.time.Month;

public class LocalDateDemo4 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate localDate = today.plusDays(10);
        System.out.println(localDate);

        LocalDate localDate1 = today.minusMonths(8);
        System.out.println(localDate1);

        System.out.println(today.isBefore(localDate));

        LocalDate today2 = LocalDate.of(2023, Month.MARCH, 7);
        System.out.println(today == today2);
        System.out.println(today2.equals(today));
    }
}
