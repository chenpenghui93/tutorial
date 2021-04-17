package com.example.javabasic.sample.classload;

/**
 * @Author cph
 * @Date 2020/1/17
 */
public class Child extends Parent {

    public static int j = childStaticMethod();

    {
        System.out.println("子类非静态初始化块");
    }

    static {
        System.out.println("子类静态初始化块");
    }

    public Child() {
        System.out.println("子类构造方法");
    }

    public static int childStaticMethod() {
        System.out.println("子类静态方法");
        return 3;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("销毁子类之前");
        super.finalize();
        System.out.println("销毁子类之后");
    }

}
