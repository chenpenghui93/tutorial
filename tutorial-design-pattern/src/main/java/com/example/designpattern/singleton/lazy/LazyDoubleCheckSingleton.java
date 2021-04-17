package com.example.designpattern.singleton.lazy;

/**
 * @author cph
 * @date 2019/4/6
 */
public class LazyDoubleCheckSingleton {

    // 使用volatile解决指令重排序问题
    private volatile static LazyDoubleCheckSingleton lazy = null;

    private LazyDoubleCheckSingleton() {
    }

    //使用双重检查锁的目的是提高性能，但因为jvm内存模型中无序写的问题，可能会失效
    public static LazyDoubleCheckSingleton getInstance() {
        //外层检查是为了让其它线程方法进来，减少锁的产生，提高性能
        //如果去掉外层if，其它线程方法就会进不来，效果与"将synchronized放在方法上"相同，达不到优化性能的目的
        if (lazy == null) {
            //内层检查锁实现线程安全
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazy == null) {
                    lazy = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazy;
    }
}
