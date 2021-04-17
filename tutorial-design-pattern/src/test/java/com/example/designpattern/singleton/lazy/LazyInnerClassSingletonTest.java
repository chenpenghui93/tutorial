package com.example.designpattern.singleton.lazy;

import java.lang.reflect.Constructor;

/**
 * @author cph
 * @date 2019/4/6
 */
public class LazyInnerClassSingletonTest {
    public static void main(String[] args) {
        //利用反射强行破坏懒汉式单例
        try {
            Class<?> clazz = LazyInnerClassSingleton.class;
            Constructor constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            Object o1 = constructor.newInstance();
            Object o2 = constructor.newInstance();
            System.out.println(o1);
            System.out.println(o2);
            System.out.println(o1 == o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}