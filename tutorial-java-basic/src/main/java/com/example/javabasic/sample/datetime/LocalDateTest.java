package com.example.javabasic.sample.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * Java8 日期时间测试
 *
 * @Author cph
 * @Date 2020/1/12
 */
public class LocalDateTest {
    public static void main(String[] args) {
        localDateTest();
        localTimeTest();
        localDateTimeTest();
    }

    /**
     * LocalDate获取各种日期
     */
    public static void localDateTest() {
        System.out.println("========LocalDate========");
        System.out.println("当前日期: " + LocalDate.now());
        System.out.println("当前日期的年: " + LocalDate.now().getYear());
        System.out.println("当前日期的月-枚举值: " + LocalDate.now().getMonth());
        System.out.println("当前日期的月-数字值: " + LocalDate.now().getMonthValue());
        System.out.println("当前日期是一个月中的第几天: " + LocalDate.now().getDayOfMonth());
        System.out.println("当前日期是一个周中的第几天-枚举值: " + LocalDate.now().getDayOfWeek());
        System.out.println("当前日期是一个周中的第几天-数字值: " + LocalDate.now().getDayOfWeek().getValue());
        System.out.println("当前日期是一年中的第几天: " + LocalDate.now().getDayOfYear());
        System.out.println("年表: " + LocalDate.now().getChronology());
        System.out.println("当前日期所在月的第一天: " + LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("当前日期所在月的最后一天: " + LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("当前日期所在月的第二天: " + LocalDate.now().withDayOfMonth(2));
        System.out.println("当前日期的前一天(minus): " + LocalDate.now().minusDays(1));
        System.out.println("当前日期的前一天(plus): " + LocalDate.now().plusDays(-1));
        System.out.println("当前日期的后一天(plus): " + LocalDate.now().plusDays(1));

        LocalDate localDate1 = LocalDate.of(2019, 12, 31);
        System.out.println("localDate1: " + localDate1);
        //需严格遵循ISO的yyyy-MM-dd格式
        LocalDate localDate2 = LocalDate.parse("2019-12-31");
        System.out.println("localDate2: " + localDate2);
    }

    /**
     * LocalTime获取各种时间
     */
    public static void localTimeTest() {
        System.out.println("========LocalTime========");
        System.out.println("当前时间: " + LocalTime.now());
        System.out.println("当前时间-时: " + LocalTime.now().getHour());
        System.out.println("当前时间-分: " + LocalTime.now().getMinute());
        System.out.println("当前时间-秒: " + LocalTime.now().getSecond());
        System.out.println("当前时间-纳秒: " + LocalTime.now().getNano());
        System.out.println("清除当前时间: " + LocalTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0));
    }

    /**
     * LocalDateTime获取日期时间
     */
    public static void localDateTimeTest() {
        System.out.println("========LocalDateTime========");
        System.out.println("当前时间戳: " + System.currentTimeMillis());
        System.out.println("当前时间(秒): " + System.currentTimeMillis() / 1000L);
        System.out.println("当前时区: " + ZoneOffset.systemDefault());

        //根据传入的时间进行操作
        LocalDateTime localDateTime = LocalDateTime.ofInstant(
                Instant.ofEpochSecond(System.currentTimeMillis() / 1000L),
                ZoneOffset.systemDefault());
        System.out.println("localDateTime: " + localDateTime);
        System.out.println("当前年: " + localDateTime.getYear());
        System.out.println("当前月: " + localDateTime.getMonth());
        System.out.println("当前日(一月中的第几天): " + localDateTime.getDayOfMonth());
        System.out.println("当前日(一周中的第几天): " + localDateTime.getDayOfWeek());
        System.out.println("当前日(一年中的第几天): " + localDateTime.getDayOfYear());
        System.out.println("当前日所在年中的第一天: " + localDateTime.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println("当前日所在年中的最后一天: " + localDateTime.with(TemporalAdjusters.lastDayOfYear()));
        System.out.println("当前日下一年中的第一天: " + localDateTime.with(TemporalAdjusters.firstDayOfNextYear()));
        System.out.println("当前日所在月中的第一天: " + localDateTime.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("当前日所在月中的最后一天: " + localDateTime.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("当前日下一月中的第一天: " + localDateTime.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println("当前时间-时: " + localDateTime.getHour());
        System.out.println("当前时间-分: " + localDateTime.getMinute());
        System.out.println("当前时间-秒: " + localDateTime.getSecond());
        System.out.println("当前时间-纳秒: " + localDateTime.getNano());

        long dayStartSeconds = localDateTime.withHour(0).withMinute(0).withSecond(0)
                .atZone(ZoneOffset.systemDefault()).toEpochSecond();
        System.out.println("传入时间某一天零分零秒的秒数: " + dayStartSeconds);

        System.out.println("当前日(一个周中的第几天)-ordinal: " + localDateTime.getDayOfWeek().ordinal());
        LocalDateTime weekStart = localDateTime.minusDays(
                localDateTime.getDayOfWeek().ordinal()).withHour(0).withMinute(0).withSecond(0);
        System.out.println("传入时间当前周第一天的零分零秒: " + weekStart);

        long monthStartSeconds = localDateTime.with(
                TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0)
                .atZone(ZoneOffset.systemDefault()).toEpochSecond();
        System.out.println("传入时间当前月第一天零分零秒的秒数: " + monthStartSeconds);

        LocalDateTime firstDayOfYear = localDateTime.with(TemporalAdjusters.firstDayOfYear());
        System.out.println("传入时间当前年的第一天: " + firstDayOfYear);

        LocalDateTime plusOneWeek = localDateTime.plusWeeks(1);
        System.out.println("当前时间向后推一周: " + plusOneWeek);
        LocalDateTime minusOneWeek = localDateTime.minusWeeks(1);
        System.out.println("当前时间向前推一周: " + minusOneWeek);

        //格式转换
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String happyTime = "2000-01-01 00:00:00";
        localDateTime = LocalDateTime.parse(happyTime, formatter);
        System.out.println("DateTimeFormatter: " + localDateTime);
    }
}
