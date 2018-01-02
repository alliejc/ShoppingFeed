package com.alliejc.shoppingfeed.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String setDateParsing(String date) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date today = new Date();
        try {
            today = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return df.format(today);
    }
}
