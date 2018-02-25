package ua.goit.java8.module7.utils;

/**
 * Created by t.oleksiv on 04/09/2017.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static Calendar calendar = Calendar.getInstance();

    public static Date convertStringToDate(String stringDate) throws ParseException {
        calendar.setTime(dateFormat.parse(stringDate));
        Date newDate = calendar.getTime();
        return newDate;
    }

    public static Boolean isSpoiled(Date dateExpiration, Date date) {
        if (dateExpiration.getTime() < date.getTime()) {
            return true;
        } else {
            return false;
        }
    }

    public static Date getDateExpiration(String dateSupply, int addDays) throws ParseException {
        calendar.setTime(dateFormat.parse(dateSupply));
        calendar.add(Calendar.DAY_OF_MONTH, addDays);
        Date newDate = calendar.getTime();
        return newDate;
    }

}