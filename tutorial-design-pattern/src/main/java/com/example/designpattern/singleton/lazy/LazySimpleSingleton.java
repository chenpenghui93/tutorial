package com.example.designpattern.singleton.lazy;

/**
 * 懒汉式单例中通过synchronized解决线程安全问题，
 * 通过双重检查锁解决由此产生的性能问题
 * 通过利用内部类特性完美解决线程安全问题，无需考虑性能问题
 *
 * @author cph
 * @date 2019/4/6
 */
public class LazySimpleSingleton {

    private static LazySimpleSingleton lazy = null;

    private LazySimpleSingleton() {
    }

//    //线程不安全
//    public static LazySimpleSingleton getInstance() {
//        //“懒”在被调用时才会实例化
//        if (lazy == null) {
//            lazy = new LazySimpleSingleton();
//        }
//        return lazy;
//    }

    /**
     * 添加关键字synchronized保证线程安全
     * 虽然jdk1.6之后优化了synchronized性能问题，但仍然存在一定问题，考虑双重检查锁解决性能问题
     */
    public synchronized static LazySimpleSingleton getInstance() {
        //“懒”在被调用时才会实例化
        if (lazy == null) {
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }
}
