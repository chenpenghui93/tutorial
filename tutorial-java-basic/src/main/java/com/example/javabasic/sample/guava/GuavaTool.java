package com.example.javabasic.sample.guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @description: guava工具类测试
 * @author: cph
 * @date: 2021/6/19 11:35
 */
public class GuavaTool {
    public static void main(String[] args) {

        // 普通集合
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3);
        HashSet<Integer> set = Sets.newHashSet(4, 5, 6);
        HashMap<String, String> map = Maps.newHashMap();

        // Set并集、差集、交集
        HashSet<Integer> set1 = Sets.newHashSet(1, 2, 3, 4, 5);
        HashSet<Integer> set2 = Sets.newHashSet(4, 5, 6, 7, 8);
        Sets.SetView<Integer> union = Sets.union(set1, set2);
        System.out.println("union: " + union);
        // 返回set1中有，set2中没有的元素
        Sets.SetView<Integer> difference = Sets.difference(set1, set2);
        System.out.println("difference: " + difference);
        Sets.SetView<Integer> intersection = Sets.intersection(set1, set2);
        System.out.println("intersection: " + intersection);


    }
}
