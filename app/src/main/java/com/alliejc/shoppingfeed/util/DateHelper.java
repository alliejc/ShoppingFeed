package com.alliejc.shoppingfeed.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateHelper {

    public static String setDateParsing(String date) {
        TimeZone timeZone = TimeZone.getDefault();
        Calendar cal = Calendar.getInstance(timeZone);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setCalendar(cal);
        try {
            cal.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return DateHelper.formatDateTitleString(cal);
    }

    private static String formatDateTitleString(Calendar calendar) {
        DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        Date date = new Date();
        if(calendar != null) {
            date.setTime(calendar.getTimeInMillis());
        }
        return dateFormat.format(date);
    }
}
