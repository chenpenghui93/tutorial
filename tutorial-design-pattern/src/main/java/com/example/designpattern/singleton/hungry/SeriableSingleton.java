package com.example.designpattern.singleton.hungry;

import java.io.Serializable;

/**
 * @author cph
 * @date 2019/4/6
 */
public class SeriableSingleton implements Serializable {

    private static final SeriableSingleton INSTANCE = new SeriableSingleton();

    private SeriableSingleton() {
    }

    public static SeriableSingleton getInstance() {
        return INSTANCE;
    }

    //重写readResolve方法覆盖反序列化出来的对象；仍然创建了两次，在JVM层面相对比较安全
    //之前反序列化出来的对象会被GC回收
    private Object readResolve() {
        return INSTANCE;
    }
}
