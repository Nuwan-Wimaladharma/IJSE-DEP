package lk.ijse.dep10;

import java.sql.Time;
import java.util.Date;

public class Conversion2 {
    public static void main(String[] args) {
        /* java.util.Date -> java.sql.Date */
        Date utilDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        /* java.util.Date -> java.sql.Time */
        java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());

        /* java.util.Date -> java.sql.Timestamp */
        java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(utilDate.getTime());

        /* java.sql.Date -> java.util.Date */
        utilDate = new java.util.Date(sqlDate.getTime());

        /* java.sql.Time -> java.util.Date */
        utilDate = new java.sql.Date(sqlTime.getTime());

        /* java.sql.Timestamp -> java.util.Date */
        utilDate = new java.sql.Date(sqlTimeStamp.getTime());
    }
}
