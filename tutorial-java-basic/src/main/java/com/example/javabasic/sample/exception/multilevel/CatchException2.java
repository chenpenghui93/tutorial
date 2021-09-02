package com.example.javabasic.sample.exception.multilevel;

/**
 * @author: cph
 * @date: 2021/9/2 14:28
 */
public class CatchException2 {
    public static void main(String[] args) {
        try {
            try {
                // 该异常直接被外层对应catch捕获
                throw new ArrayIndexOutOfBoundsException();
            } catch (ArithmeticException e) {
                // 此处代码未执行
                System.out.println("内层发生异常ArithmeticException " + e);
            }
            // 此处代码未执行
            throw new ArithmeticException();
        } catch (ArithmeticException e) {
            // 此处代码未执行
            System.out.println("外层发生异常ArithmeticException " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("外层发生异常ArrayIndexOutOfBoundsException " + e);
        }
    }
}
