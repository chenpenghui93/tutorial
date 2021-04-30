package com.example.javabasic.sample.gc;

/**
 * @author chenpenghui
 * @date 2021-4-30
 */
public class ReferenceCountingGC {

    public Object instance = null;

    public static void test() {

        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        // 对象循环引用，引用计数永远不可能为0
        objA.instance = objB;
        objB.instance = objA;

        // 指向的对象不再被访问
        objA = null;
        objB = null;

        System.gc();
    }
}
