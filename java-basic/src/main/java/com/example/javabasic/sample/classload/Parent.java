package com.example.javabasic.sample.classload;

/**
 * @Author cph
 * @Date 2020/1/17
 */
public class Parent {

    public static int i = parentStaticMethod2();

    {
        System.out.println("父类非静态初始化块");
    }

    static {
        System.out.println("父类静态初始化块");
    }

    public Parent() {
        System.out.println("父类构造方法");
    }

    public static int parentStaticMethod1() {
        System.out.println("父类静态方法1");
        return 1;
    }

    public static int parentStaticMethod2() {
        System.out.println("父类静态方法2");
        return 2;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("销毁父类之前");
        super.finalize();
        System.out.println("销毁父类之后");
    }
}
