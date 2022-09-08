package org.example.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateOfDay {

    //获取当前是星期几
    public String getWeek(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        return sdf.format(date);
    }

    //获取现在是几点几分
    public String getTime(Date date)
    {
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
        return sdf2.format(date);
    }

    //获取现在是第几周
    public int getWeekNumber(Date date)
    {
        GregorianCalendar g = new GregorianCalendar();
        g.setTime(date);
        return g.get(Calendar.WEEK_OF_YEAR) - 35;
    }


}
