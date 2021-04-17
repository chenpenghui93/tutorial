package com.example.designprinciple.dip.after;

/**
 * @author cph
 * @date 2019/11/16
 */
public class Test {
    public static void main(String[] args) {
        Tony tony = new Tony();
        tony.study(new JavaCourse());
        tony.study(new PythonCourse());

        //这种代码结构中，对于新课程，只需创建新类，在调用时传参即可，不需要修改底层代码。实现了依赖注入

        //注入还有构造器方式和setter方式

        //构造器注入,每次调用都需要创建实例
        Tony1 tony1 = new Tony1(new JavaCourse());
        tony1.study();

        //setter注入
        Tony2 tony2 = new Tony2();
        tony2.setCourse(new PythonCourse());
        tony2.study();

        //以抽象为基准 比 以细节为基准 搭建的架构要稳定的多
        //拿到需求后，要面向接口编程，先顶层再细节来设计代码结构
    }
}
