package com.example.designpattern.proxy.staticproxy.datasource;

/**
 * @Author cph
 * @Date 2020/1/30
 */
public class DynamicDataSourceEntity {

    private final static String DEFAULT_SOURCE = null;

    private final static ThreadLocal<String> local = new ThreadLocal<>();

    private DynamicDataSourceEntity() {
    }

    /**
     * 清空数据源
     */
    public static void clear() {
        local.remove();
    }

    /**
     * 获取当前数据源
     *
     * @return
     */
    public static String get() {
        return local.get();
    }

    /**
     * 还原当前切面的数据源
     */
    public static void restore() {
        local.set(DEFAULT_SOURCE);
    }

    /**
     * 设置数据源
     *
     * @param source
     */
    public static void set(String source) {
        local.set(source);
    }

    /**
     * 根据当前年份设置数据源
     *
     * @param year
     */
    public static void set(int year) {
        local.set("DB_" + year);
    }

}
