package com.example.designpattern.singleton.register;

/**
 * @author cph
 * @date 2019/4/6
 */
public class ContainerSingletonTest {
    public static void main(String[] args) {
        Object object = ContainerSingleton.getBean("com.example.designpattern.singleton.register.ContainerSingleton");
        System.out.println(object);
    }
}