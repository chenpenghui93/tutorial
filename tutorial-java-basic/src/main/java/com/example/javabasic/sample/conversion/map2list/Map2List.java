package com.example.javabasic.sample.conversion.map2list;

import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author cph
 * @Date 2020/1/12
 */
public class Map2List {
    public static void main(String[] args) throws Exception {
        Student1 s1 = new Student1(1L, "zhangsan", 90);
        Map map = BeanUtils.describe(s1);

        //将Map中的key转为list
        List<String> keyList = new ArrayList<>(map.keySet());
        System.out.println(keyList);

        //将Map中的value转为list
        List<?> valueList = new ArrayList<>(map.values());
        System.out.println(valueList);

    }
}
