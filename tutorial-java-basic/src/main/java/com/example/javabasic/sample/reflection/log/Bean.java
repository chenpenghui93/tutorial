package com.example.javabasic.sample.reflection.log;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @description: 测试Bean
 * @author: cph
 * @date: 2021/7/30 16:37
 */
@Data
@Builder
public class Bean {

    private Long id;

    @ForUpdate(filedName = "姓名")
    private String name;

    @ForUpdate(filedName = "年龄")
    private Integer age;

    @ForUpdate(filedName = "日期")
    private Date date;
}
