package com.example.javabasic.sample.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author chenpenghui
 * @date 2020/7/25
 */
public class DateTimeDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        System.out.println(formatter.format(localDateTime));

        formatter = DateTimeFormatter.ofPattern("YY/M/d H:m:s");
        System.out.println(formatter.format(localDateTime));
    }
}
