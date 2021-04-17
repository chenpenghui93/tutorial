package com.example.javabasic.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期与cron表达式转换
 *
 * @author chenpenghui
 * @date 2021-2-23
 */
public class CronUtil {

    /**
     * 格式化日期
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String formatDateByPattern(Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatStr = null;
        if (date != null) {
            formatStr = sdf.format(date);
        }
        return formatStr;
    }

    /**
     * 获取cron表达式
     *
     * @param date
     * @return
     */
    public static String getCron(Date date) {
        String dateFormat = "ss mm HH dd MM ? yyyy";
        return formatDateByPattern(date, dateFormat);
    }

    public static void main(String[] args) {
        String cron = CronUtil.getCron(new Date());
        System.out.println(cron);
    }

}
