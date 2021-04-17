package com.example.designprinciple.srp.before;

/**
 * @author cph
 * @date 2019/11/16
 */
public class Test {
    public static void main(String[] args) {
        Course course = new Course();
        course.study("直播课");
        course.study("录播课");

        //Course类承担了两种处理逻辑，当对其中一种逻辑进行变更修改代码时，势必会相互影响造成未知风险
    }
}
