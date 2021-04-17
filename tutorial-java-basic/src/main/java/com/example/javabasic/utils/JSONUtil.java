package com.example.javabasic.utils;

import com.alibaba.fastjson.JSON;

/**
 * JSON转换工具类
 *
 * @author chenpenghui
 * @date 2018/12/20
 */
public class JSONUtil {

    /**
     * Java 对象转换为 JSON 字符串
     *
     * @param object
     * @return String
     */
    public static final String toJson(final Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * JSON 字符串解析为 Java 对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return T
     */
    public static final <T> T toObject(final String json, final Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

}
