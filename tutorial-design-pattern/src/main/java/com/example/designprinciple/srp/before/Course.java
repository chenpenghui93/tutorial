package com.example.designprinciple.srp.before;

/**
 * @author cph
 * @date 2019/11/16
 */
public class Course {
    public void study(String typeName) {
        if ("直播课".equals(typeName)) {
            System.out.println("不能快进");
        } else {
            System.out.println("可以回退、快进");
        }
    }
}
