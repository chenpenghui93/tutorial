package com.example.designprinciple.ocp;

/**
 * @author cph
 * @date 2019/11/15
 */
public class Test {
    public static void main(String[] args) {
        //Java测试类
        JavaDiscountCourse javaDiscountCourse = new JavaDiscountCourse(1, "java", 100.0);
        System.out.println(javaDiscountCourse.getDiscountPrice());

        //新增Python、C++等课程只需创建新类，实现接口相应方法即可，无需修改原代码
        //实现对扩展开放，对修改关闭
    }
}
