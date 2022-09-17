package org.example.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateOfDay {


    //获取当前是星期几。
    public static String getWeek(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        return sdf.format(date);
    }

    //获取现在是几点几分。
    public static String getTime(Date date) {
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
        return sdf2.format(date);
    }

    //获取现在是第几周。
    public static int getWeekNumber(Date date) {
        GregorianCalendar g = new GregorianCalendar();
        g.setTime(date);
        return g.get(Calendar.WEEK_OF_YEAR) - 35;
    }

    //获取明天是星期几。
    public static String getWeek_tomorrow(){
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, +1);
        return sdf.format(calendar.getTime());
    }

    //获取明天是第几周。
    public static int getWeekNumber_tomorrow(){
        GregorianCalendar g = new GregorianCalendar();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, +1);
        return g.get(Calendar.WEEK_OF_YEAR) - 35;
    }
}
