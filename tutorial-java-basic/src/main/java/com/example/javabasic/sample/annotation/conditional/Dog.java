package com.example.javabasic.sample.annotation.conditional;

/**
 * @author chenpenghui
 * @date 2020-12-31
 */
//@Service
public class Dog implements Animal {
    @Override
    public String eat() {
        return "meat";
    }
}
