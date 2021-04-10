package com.example.javabasic.sample.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author cph
 * @date 2019/6/28
 */
public class ConvertDateTime {
    public static void main(String[] args) {
        date2LocalDate();
        localDate2Date();
        unixTimeTest();
        string2LocalDate();
    }

    /**
     * Date 转 LocalDate
     */
    private static void date2LocalDate() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        // 2020-08-29
        System.out.println(localDate);
    }

    /**
     * LocalDate 转 Date
     */
    private static void localDate2Date() {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        Date date = Date.from(zdt.toInstant());

        // Asia/Shanghai
        System.out.println(zoneId);

        // 2020-08-29
        System.out.println(localDate);

        // 2020-08-29T00:00+08:00[Asia/Shanghai]
        System.out.println(zdt);

        // Sat Aug 29 00:00:00 CST 2020
        System.out.println(date);
    }

    /**
     * 获取指定时区时间
     */
    private static void unixTimeTest() {

        long t = System.currentTimeMillis();
        // 1598692179814
        System.out.println(t);

        // 当前时区
        SimpleDateFormat sdf_default = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 2020-08-29 17:09:39
        System.out.println(sdf_default.format(t));

        // +8:00
        SimpleDateFormat sdf_8 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf_8.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        // 2020-08-29 17:09:39
        System.out.println(sdf_8.format(t));

        // +7:00
        SimpleDateFormat sdf_7 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf_7.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));
        // 2020-08-29 16:09:39
        System.out.println(sdf_7.format(t));

        // -9:00
        SimpleDateFormat sdf_la = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf_la.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        // 2020-08-29 02:09:39
        System.out.println(sdf_la.format(t));
    }

    /**
     * String日期 转 LocalDate
     */
    private static void string2LocalDate() {
        //Java 8 – How to convert String to LocalDate
        //https://www.mkyong.com/java8/java-8-how-to-convert-string-to-localdate/

        //default, ISO_LOCAL_DATE
        String date1 = "2019-06-29";
        LocalDate localDate1 = LocalDate.parse(date1);
        System.out.println("localDate1: " + localDate1);

        // DateTimeFormatter.ofPattern()中JVM会自动获取出当前的时区，并按照此时区进行字符串对比
        // 示例日期字符串需要根据所在时区进行构造, Aug是英系时区的字符
        // 否则会出现 Exception in thread "main" java.time.format.DateTimeParseException: Text '16-Aug-2016' could not be parsed at index 3
        // 原因是底层代码会将 Aug 与 8 比较？
        String date2 = "29-6-2018";
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d-M-yyyy");
        LocalDate localDate2 = LocalDate.parse(date2, formatter2);
        System.out.println("localDate2: " + localDate2);
        System.out.println("formatter2.format(): " + formatter2.format(localDate2));

        // "d/M/yyyy" 可转换 "16/08/2016"、"6/10/2016"
        // "dd/MM/yyyy" 仅可转换 "06/08/2016"
        // 实际中推荐使用 "d/M/yyyy"
        String date3 = "16/08/2016";
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate3 = LocalDate.parse(date3, formatter3);
        System.out.println("localDate3: " + localDate3);
        System.out.println("formatter3.format(): " + formatter3.format(localDate3));

        //The ‘Z’ suffix means UTC, you can convert into a java.time.instant directly, then display it with a time zone.
        String date4 = "2016-08-16T15:23:01Z";
        Instant instant = Instant.parse(date4);
        System.out.println("Instant: " + instant);
        //datetime time
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));
        //localdate
        System.out.println("localDateTime: " + localDateTime.toLocalDate());
        //datetime time + timezone
        ZonedDateTime zonedDateTime1 = instant.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println("zonedDateTime1: " + zonedDateTime1);
        ZonedDateTime zonedDateTime2 = instant.atZone(ZoneId.of("Europe/Athens"));
        System.out.println("zonedDateTime2: " + zonedDateTime2);

        //String -> ZonedDateTime -> LocalDate
        String date5 = "2016-08-16T10:15:30+08:00";
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(date5, DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("ZonedDateTime: " + zonedDateTime);
        System.out.println("TimeZone: " + zonedDateTime.getZone());
        LocalDate localDate5 = zonedDateTime.toLocalDate();
        System.out.println("LocalDate5: " + localDate5);

        String dateString6 = "2016-6-29";
        SimpleDateFormat formatter6 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date6 = formatter6.parse(dateString6);
            System.out.println("date6: " + date6);
            System.out.println("formatter6.format(): " + formatter6.format(date6));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("LocalDate.now(): " + LocalDate.now());
    }

}
