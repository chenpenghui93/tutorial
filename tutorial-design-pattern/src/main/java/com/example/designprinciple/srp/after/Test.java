package com.example.designprinciple.srp.after;

/**
 * @author cph
 * @date 2019/11/16
 */
public class Test {
    public static void main(String[] args) {
        LiveCourse liveCourse = new LiveCourse();
        liveCourse.study("直播课");

        ReplayCourse replayCourse = new ReplayCourse();
        replayCourse.study("录播课");

        //在修改其中一种类型处理逻辑时，不会对另外一种类型处理逻辑产生影响
        //尽可能地让接口和方法保持单一职责有助于项目后期的维护
    }
}
