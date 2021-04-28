package com.example.designpattern.singleton.hungry;

/**
 * @author cph
 * @date 2019/4/6
 */
public class HungrySingleton {

    /**
     * 首次加载时就创建实例，使用final关键字防止被覆盖
     */
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    /**
     * 私有的构造器
     */
    private HungrySingleton() {
    }

    /**
     * 公共的全局访问点
     */
    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}
