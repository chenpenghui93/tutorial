package com.example.javabasic.sample.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author cph
 * @Date 2020/1/12
 */
public class EntryTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        //场景一，通过Map.values()遍历value，但不能遍历key
        for (String value : map.values()) {
        }
        System.out.println("==========================================");

        //场景二，通过Map.keySet遍历key和value
        for (String key : map.keySet()) {
            System.out.println("key=" + key + ", value=" + map.get(key));
        }
        System.out.println("===========================================");

        //场景三，通过Map.entrySet使用iterator遍历key和value
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("entry: " + entry);
            System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
        }
        System.out.println("===========================================");

        //场景四，通过Map.entrySet遍历key和value，适用于容量较大的时候,推荐使用
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("entry: " + entry);
            System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
        }
        System.out.println("==========================================");
    }
}
