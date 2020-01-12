package com.jarvis.gmall.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * gmall : com.jarvis.gmall.util
 *
 * @author jarvis
 * @create 2019-12-25 20:20
 */
public class MyDateUtil {

    public static String formatDate(String pattern, Date date){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String dateStr = format.format(date);
        return dateStr;
    }

    public static Date getDate(int field, int diff) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(field,diff);
        return calendar.getTime();
    }
}
