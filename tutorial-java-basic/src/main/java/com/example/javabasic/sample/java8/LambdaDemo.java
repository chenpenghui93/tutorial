package com.example.javabasic.sample.java8;

/**
 * 可选的参数类型声明 ： 无需声明参数的类型。编译器可以从参数的值推断出相同的值
 * 可选的参数周围的小括号 () ： 如果只有一个参数，可以忽略参数周围的小括号。但如果有多个参数，则必须添加小括号
 * 可选的大括号 {} : 如果 Lambda 表达式只包含一条语句，那么可以省略大括号。但如果有多条语句，则必须添加大括号
 * 可选的 return 关键字 ：
 * 如果 Lambda 表达式只有一条语句，那么编译器会自动 return 该语句最后的结果
 * 但如果显式使用了 return 语句，则必须添加大括号 {} ，哪怕只有一条语句
 *
 * @author chenpenghui
 * @date 2020/7/19
 */
public class LambdaDemo {
    public static void main(String[] args) {
        LambdaDemo tester = new LambdaDemo();

        // 有声明参数类型
        MathOperation addition = (int a, int b) -> a + b;

        // 没有声明参数类型
        MathOperation subtraction = (a, b) -> a - b;

        // 使用 return 语句显式返回值需要添加大括号
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 如果只有一条语句，那么可以省略大括号，Java 会返回表达式的值
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    interface MathOperation {
        int operation(int a, int b);
    }
}
