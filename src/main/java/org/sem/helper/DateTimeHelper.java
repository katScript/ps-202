package org.sem.helper;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTimeHelper {
    public static String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    public static Date stringToDate(String date) {
        try {
            return new Date(new SimpleDateFormat("dd/MM/yyyy").parse(date).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
