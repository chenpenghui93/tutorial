package com.example.designpattern.singleton.lazy;

/**
 * @author cph
 * @date 2019/4/6
 */
public class LazyInnerClassSingleton {
    private LazyInnerClassSingleton() {
        //若不加此判断，调用者可利用反射强行破坏单例
        if (LazyHolder.LAZY != null) {
            throw new RuntimeException("不允许构建多个实例！");
        }
    }

    /**
     * Java机制规定：内部类LazyHolder只有在getInstance()方法第一次被调用的时候才会被加载，而且其加载过程是线程安全的
     */
    public static final LazyInnerClassSingleton getInstance() {
        return LazyHolder.LAZY;
    }

    private static final class LazyHolder {
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}
