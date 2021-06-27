package com.example.javabasic.utils;

import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description: 日期工具类
 * @author: lzj
 * @date: 2021/03/25 16:41
 */
public class DateUtil {
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_MS_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DEFAULT_DATENO_FORMAT = "yyyyMMddHHmmssS";
    public static final String DEFAULT_DAY_FORMAT = "yyyy-MM-dd";
    public static final String DAY_FORMAT_LIMIT = "yyyyMMdd";
    private static final String START_TIME = " 00:00:00";
    private static final String END_TIME = " 23:59:59";
    public static final String[] WEEK_DAYS = new String[]{"日", "一", "二", "三", "四", "五", "六"};

    private DateUtil() {
    }

    /**
     * @param date date
     * @return java.util.Date
     * @description 返回给定日期的0点 如2021-06-03 00：00：00
     * @author hebin
     * @date 2021/6/3 6:52 下午
     */
    public static Date getDateStartTime(Date date) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(date);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);
        long time = fromCalendar.getTime().getTime();
        return new Date(time);
    }

    public static Date getDateEndTime(Date date) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(date);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 23);
        fromCalendar.set(Calendar.MINUTE, 59);
        fromCalendar.set(Calendar.SECOND, 59);
        fromCalendar.set(Calendar.MILLISECOND, 999);
        long time = fromCalendar.getTime().getTime();
        return new Date(time);
    }

    public static String getDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String dateToString(Date date, String format) {
        if (null == date) {
            return null;
        } else {
            if (StringUtils.isEmpty(format)) {
                format = "yyyy-MM-dd HH:mm:ss";
            }

            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }
    }

    public static Date stringToDate(String strDate, String format) {
        if (StringUtils.isEmpty(strDate)) {
            return null;
        } else {
            if (StringUtils.isEmpty(format)) {
                format = "yyyy-MM-dd HH:mm:ss";
            }

            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date date = null;

            try {
                date = sdf.parse(strDate);
            } catch (Exception var5) {
                System.err.println("转换时间失败");
                var5.printStackTrace();
            }

            return date;
        }
    }

    public static String getDayString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date());
    }

    public static String timestampToString(Timestamp time) {
        Date date = new Date(time.getTime());
        return dateToString(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String timestampToString(Timestamp time, String format) {
        Date date = new Date(time.getTime());
        return dateToString(date, format);
    }

    public static Timestamp stringToTimestamp(String string) {
        Date date = stringToDate(string, "yyyy-MM-dd HH:mm:ss");
        return new Timestamp(date.getTime());
    }

    public static int intervalDays(Date date1, Date date2) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(date1);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);
        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(date2);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);
        int days = (int) ((toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / 86400000L);
        return Math.abs(days);
    }

    public static Date nDaysAfterByDate(Date basicDate, int n) {
        long nDay = (basicDate.getTime() / 86400000L + 1 + (long) n) * 86400000L;
        Date date = new Date();
        date.setTime(nDay);
        return date;
    }

    public static String nDaysAfterByString(String dateString, int n) {
        Date date = stringToDate(dateString, "yyyy-MM-dd HH:mm:ss");
        Date result = nDaysAfterByDate(date, n);
        return dateToString(result, "yyyy-MM-dd HH:mm:ss");
    }

    public static int getDayByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(5);
    }

    public static int getMonthByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(2) + 1;
    }

    public static int getYearByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(1);
    }

    public static Date stringToDay(String strDay) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(strDay);
    }

    public static Date getTodayStartTime() throws ParseException {
        String strDay = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date()) + " 00:00:00";
        return stringToDay(strDay);
    }

    public static Date getTodayEndTime() throws ParseException {
        String strDay = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date()) + " 23:59:59";
        return stringToDay(strDay);
    }

    public static Date getNowTime() {
        return new Date();
    }

    public static long plusSeconds(Date date, long seconds) {
        long time = date.getTime() / 1000;
        return time + seconds;
    }
}
