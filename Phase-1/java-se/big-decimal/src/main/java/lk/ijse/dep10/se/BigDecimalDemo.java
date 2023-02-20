package lk.ijse.dep10.se;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        double d1 = 0.3;
        double d2 = 0.2;
        double result = d1 - d2;
        System.out.println(result);

        BigDecimal bd1 = new BigDecimal("0.3"); //String is essential
        BigDecimal bd2 = new BigDecimal("0.2");
        //or
        BigDecimal bd1New = BigDecimal.valueOf(d1);
        BigDecimal bd2New = BigDecimal.valueOf(d2);

        BigDecimal bdResult = bd1.subtract(bd2);
        System.out.println(bdResult);
        System.out.println("New: " + bdResult);
    }
}
