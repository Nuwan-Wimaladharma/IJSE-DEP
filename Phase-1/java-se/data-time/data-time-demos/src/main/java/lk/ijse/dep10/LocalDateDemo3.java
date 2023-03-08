package lk.ijse.dep10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateDemo3 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020, 10, 01);
        LocalTime time = LocalTime.of(5, 7, 10);

        LocalDateTime dateTime = date.atTime(time);
        System.out.println(dateTime);
        LocalDateTime dateTime3 = time.atDate(date);
        System.out.println(dateTime3);
        LocalDateTime dateTime1 = date.atStartOfDay();
        System.out.println(dateTime1);

        LocalDateTime dateTime2 = LocalDateTime.of(2022, 5, 3, 5, 10);
        System.out.println(dateTime2);
        LocalDate localDate = dateTime2.toLocalDate();
        System.out.println(localDate);
        LocalTime localTime = dateTime2.toLocalTime();
        System.out.println(localTime);
    }
}
