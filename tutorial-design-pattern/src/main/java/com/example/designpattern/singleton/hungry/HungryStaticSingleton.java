package com.example.designpattern.singleton.hungry;

/**
 * @author cph
 * @date 2019/4/6
 */
public class HungryStaticSingleton {

    /**
     * 首次加载时就创建实例,使用final关键字防止被覆盖
     */
    private static final HungryStaticSingleton hungrySingleton;

    // 通过静态代码块去初始化，程序启动时就执行
    static {
        hungrySingleton = new HungryStaticSingleton();
    }

    /**
     * 私有的构造器
     */
    private HungryStaticSingleton() {
    }

    /**
     * 公共的全局访问点
     */
    public static HungryStaticSingleton getInstance() {
        return hungrySingleton;
    }
}
