package com.example.designpattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cph
 * @date 2019/4/6
 */
public class ContainerSingleton {

    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    private ContainerSingleton() {
    }

    public static Object getBean(String className) {
        if (!ioc.containsKey(className)) {
            Object obj = null;
            try {
                obj = Class.forName(className).getDeclaredConstructor().newInstance();
                ioc.put(className, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return obj;
        }
        return ioc.get(className);
    }
}
