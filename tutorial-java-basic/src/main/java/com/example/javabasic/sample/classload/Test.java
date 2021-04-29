package com.example.javabasic.sample.classload;

/**
 * 1、虚拟机首次加载Java类时，会对静态成员变量、静态代码块、静态方法进行一次初始化
 * 2、只有在调用new时才会创建类实例
 * 3、类实例的创建过程：先父类后子类，先静态后非静态
 * 父类静态变量→父类静态初始化块→子类静态变量→子类静态初始化块→父类非静态初始化块→父类构造方法→子类非静态初始化块→子类构造方法
 * 4、类销毁顺序：先子类后父类
 * 5、当类的字节码文件被加载到内存中时，类实例方法不会被分配入口地址；只有当该类创建实例对象后，类中的实例方法才会被分配入口地址，
 * 同时入口地址被所有实例对象共享，当所有的对象都不存在时，方法的入口地址才会被销毁
 * 6、static修饰的类方法在该类被加载到内存中时，就分配了相应的入口地址,因此，类方法不仅可以被类创建的任何对象调用执行，也可以直接通过
 * 类名调用执行；类方法的入口地址直到程序退出时才被取消
 *
 * @Author cph
 * @Date 2020/1/17
 */
public class Test {

    public static void main(String[] args) {
        //Parent.parentStaticMethod1();
        Child child = new Child();
        try {
            child.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
