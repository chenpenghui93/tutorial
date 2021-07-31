package com.example.javabasic.sample.reflection.log;

import java.lang.annotation.*;

/**
 * @description: 记录更新字段
 * @author: cph
 * @date: 2021/7/30 16:35
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ForUpdate {
    String filedName() default "";
}
