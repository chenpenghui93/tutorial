package com.example.javabasic.sample.java8;

/**
 * 接口默认方法可以有具体实现
 * 接口默认方法需要使用 default 关键字修饰
 * 一个接口可以有任意数量的默认方法，也可以没有默认方法
 * 如果一个类实现的两个接口都有一个同名的默认方法，那么该类必须自己实现同样的方法(编译阶段就会提示)，然后在实现内部可以调用相应接口的方法
 * Java 8 支持接口中的静态方法，但静态方法必须有实现，不支持静态方法声明，static 与 abstract 关键字不兼容
 *
 * @author chenpenghui
 * @date 2020/7/25
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        InterfaceDemo d = new InterfaceDemo();
        d.run();
    }

    public void run() {
        Hello1 h1 = new Hello();
        h1.hello1();
        h1.sayHi();

        Hello2 h2 = new Hello();
        h2.hello2();
        h2.sayHi();
    }

    interface Hello1 {
        static void staticMethod() {
            System.out.println("static");
        }

        default void sayHi() {
            System.out.println("hi, Hello1");
        }

        default void hello1() {
            System.out.println("hello1");
        }
    }

    interface Hello2 {
        default void sayHi() {
            System.out.println("hi, Hello2");
        }

        default void hello2() {
            System.out.println("hello2");
        }
    }

    class Hello implements Hello1, Hello2 {
        @Override
        public void sayHi() {
            System.out.println("hi, Hello");
        }
    }
}
