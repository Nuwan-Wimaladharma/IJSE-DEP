package lk.ijse.dep10;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class LocalDateDemo5 {
    public static void main(String[] args) {
        LocalDate d1 = LocalDate.of(2023, 10, 3);
        LocalDate d2 = LocalDate.of(2020, 1, 3);

        Duration diff = Duration.between(d2.atStartOfDay(), d1.atStartOfDay()); //for time related calculations
        System.out.println(diff);
        System.out.println(diff.toDays());
        System.out.println(diff.toHours());
        System.out.println(diff.toMinutes());
        System.out.println(diff.toSeconds());

        System.out.println("============");

        Period diff2 = Period.between(d2, d1); //for days related calculations
        System.out.println(diff2);
        System.out.println(diff2.getDays());
        System.out.println(diff2.getYears());
        System.out.println(diff2.getMonths());
    }
}
