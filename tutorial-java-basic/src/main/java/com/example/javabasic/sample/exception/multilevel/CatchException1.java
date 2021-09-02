package com.example.javabasic.sample.exception.multilevel;

/**
 * @author: cph
 * @date: 2021/9/2 12:10
 */
public class CatchException1 {
    public static void main(String[] args) {
        try {
            try {
                // 该异常被内层catch捕获
                throw new ArrayIndexOutOfBoundsException();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("内层发生异常ArrayIndexOutOfBoundsException " + e);
            }
            // 该异常被外层对应catch捕获
            throw new ArithmeticException();
        } catch (ArithmeticException e) {
            System.out.println("外层发生异常ArithmeticException " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("外层发生异常ArrayIndexOutOfBoundsException " + e);
        }
    }
}
