package com.example.javabasic.sample.exception.example1;

/**
 * @author chenpenghui
 * @date 2021-4-4
 */
public class ExampleB extends ExampleA {
    public static void main(String[] args) {
        try {
            throw new ExampleB("b");
        } catch (ExampleA e) {
            System.out.println("ExampleA");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    public ExampleB(String s) {
    }
}
