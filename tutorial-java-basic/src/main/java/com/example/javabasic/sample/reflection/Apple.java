package com.example.javabasic.sample.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * https://www.cnblogs.com/chanshuyi/p/head_first_of_reflection.html
 *
 * @author cph
 * @date 2019/7/22
 */
public class Apple {

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Apple(){}

    public static void main(String[] args) throws Exception {

        /*
         * 正常调用
         * new Object()
         */
        Apple apple = new Apple();
        apple.setPrice(10);
        System.out.println("正常调用：price=" + apple.getPrice());

        /*
         * 反射调用
         * 1.获取类的Class对象实例
         * 2.利用Class对象实例获取Constructor对象实例
         * 3.利用Constructor对象实例的newInstance()方法获取目标类实例
         * 4.利用Class对象实例获取Method对象实例
         * 5.利用invoke()调用方法
         */
        Class clazz = Class.forName("com.example.javabasic.sample.reflection.Apple");
        Constructor appleConstructor = clazz.getConstructor();
        Object appleObject = appleConstructor.newInstance();
        Method setPriceMethod = clazz.getMethod("setPrice", int.class);
        setPriceMethod.invoke(appleObject, 20);
        Method getPriceMethod = clazz.getMethod("getPrice");
        System.out.println("反射调用：price=" + getPriceMethod.invoke(appleObject));

        //获取所有属性
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("========属性========");
        for (Field field : fields) {
            System.out.println(field.getType() + " " + field.getName());
        }

        //获取所有方法
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("========方法========");
        for (Method method : methods) {
            //返回类型
            Class returnType = method.getReturnType();
            //参数类型
            Class[] parameterTypes = method.getParameterTypes();
            System.out.print(returnType.getName() + " " + method.getName() + "(");
            for (Class parameter : parameterTypes) {
                System.out.print(parameter.getName());
            }
            System.out.println(")");
        }

        //获取所有构造器
        Constructor[] constructors = clazz.getDeclaredConstructors();
        System.out.println("========构造器========");
        for (Constructor constructor : constructors) {
            Class[] parameterTypes = constructor.getParameterTypes();
            System.out.print(constructor.getName() + "(");
            for (Class parameter : parameterTypes) {
                System.out.print(parameter.getName());
            }
            System.out.println(")");
        }
    }
}
