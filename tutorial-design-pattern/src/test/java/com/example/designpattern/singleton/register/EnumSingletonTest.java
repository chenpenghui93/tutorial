package com.example.designpattern.singleton.register;

import java.lang.reflect.Constructor;

/**
 * @author cph
 * @date 2019/4/6
 */
public class EnumSingletonTest {
//    public static void main(String[] args) {
//        try {
//            EnumSingleton instance1 = null;
//            EnumSingleton instance2 = EnumSingleton.getInstance();
//            instance2.setObject(new Object());
//
//            FileOutputStream fos = new FileOutputStream("EnumSingleton.obj");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(instance2);
//            oos.flush();
//            oos.close();
//
//            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            instance1 = (EnumSingleton) ois.readObject();
//            ois.close();
//
//            System.out.println(instance1.getObject());
//            System.out.println(instance2.getObject());
//            System.out.println(instance1.getObject() == instance2.getObject());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        try {
            Class<?> clazz = EnumSingleton.class;
            //不传参时会报错java.lang.NoSuchMethodException
            //从反编译出的类文件中可以看到没有无参构造器，只有一个包含参数String和int的构造器
            Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            //通过源码可以看到jdk层面已经防止枚举被反射破坏
            EnumSingleton obj = (EnumSingleton) constructor.newInstance("amazing", int.class);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}