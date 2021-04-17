package com.example.javabasic.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 * 日期时间工具类
 *
 * @author chenpenghui
 * @date 2021-4-4
 */
public class DateTimeUtil {

    /**
     * 获取当前日期 例 2021-04-03
     *
     * @return LocalDate
     */
    public static LocalDate getCurrentDay() {
        return LocalDate.now();
    }

    /**
     * 获取当前年份 例 2021
     *
     * @return
     */
    public static int getCurrentYear() {
        return LocalDate.now().getYear();
    }

    /**
     * 获取当前月份 枚举类型 例 APRIL
     *
     * @return Month
     */
    public static Month getCurrentMonth() {
        return LocalDate.now().getMonth();
    }

    /**
     * 获取当前月份 数字类型 例 4
     *
     * @return int
     */
    public static int getCurrentMonthValue() {
        return LocalDate.now().getMonthValue();
    }

    /**
     * 获取当前日是一个月中的第几天 例 3
     *
     * @return int
     */
    public static int getCurrentDayOfMonth() {
        return LocalDate.now().getDayOfMonth();
    }

    /**
     * 获取当前日是一周中的第几天 例 SATURDAY
     *
     * @return DayOfWeek
     */
    public static DayOfWeek getCurrentDayOfWeek() {
        return LocalDate.now().getDayOfWeek();
    }

    /**
     * 获取当前日是一周中的第几天 例 6
     *
     * @return int
     */
    public static int getCurrentDayOfWeekValue() {
        return LocalDate.now().getDayOfWeek().getValue();
    }

    /**
     * 获取当前日是一年中的第几天 例 93
     *
     * @return int
     */
    public static int getCurrentDayOfYear() {
        return LocalDate.now().getDayOfYear();
    }
}
