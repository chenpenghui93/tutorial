package com.example.designpattern.flyweight.jdk;

/**
 * @author chenpenghui
 * @date 2021-3-28
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "he" + "llo";
        String s4 = "hel" + new String("lo");
        String s5 = new String("hello");
        String s6 = s5.intern();
        String s7 = "h";
        String s8 = "ello";
        String s9 = s7 + s8;

        // true 常量在编译时被分配在常量池中，对象声明在堆中，s1、s2拿到的是 常量的引用，即同一个内存地址
        System.out.println(s1 == s2);
        // true jvm编译时对常量运算进行了优化，常量池中存在he/llo/hello s1、s3是同一个引用
        System.out.println(s1 == s3);
        // false 出现new操作符，s4赋值操作产生新对象，引用不同
        System.out.println(s1 == s4);
        // false jvm只对常量进行了编译优化，对变量不做优化，产生新对象
        System.out.println(s1 == s9);
        // false 不同引用，内存地址不同
        System.out.println(s4 == s5);
        // true
        // 调用intern()时，能使一个位于堆中的字符串在运行期间动态地加入到字符串常量池
        // 如果常量池中存在当前字符串, 就会直接返回当前字符串；如果常量池中没有此字符串, 会将此字符串放入常量池中后, 再返回
        System.out.println(s1 == s6);


    }
}
