package com.example.javabasic.sample.reflection.office;

/**
 * @author cph
 * @date 2019/7/25
 */
public class OfficeTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("com.example.javabasic.sample.reflection.office.Excel");
        OfficeAble oa = (OfficeAble)clazz.newInstance();
        oa.start();
    }
}
