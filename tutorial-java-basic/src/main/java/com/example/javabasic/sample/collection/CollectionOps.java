package com.example.javabasic.sample.collection;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: 集合类各种操作
 * @author: cph
 * @date: 2021-8-18
 */
public class CollectionOps {
    public static void main(String[] args) {
//        collectionOperation();
        mergeList();

    }

    /**
     * 交、差、并(去重)操作 jdk8 stream
     */
    private static void collectionOperation() {
        List<String> list1 = Lists.newArrayList("1", "2", "3", "4");
        List<String> list2 = Lists.newArrayList("3", "4", "5", "6");

        // 交集
        List<String> intersection = list1.stream().filter(t -> list2.contains(t)).collect(Collectors.toList());

        // 差集 list1 - list2
        List<String> reduce1 = list1.stream().filter(t -> !list2.contains(t)).collect(Collectors.toList());
        // 差集 list2 - list
        List<String> reduce2 = list2.stream().filter(t->!list1.contains(t)).collect(Collectors.toList());

        // 并集
        List<String> listAll = new ArrayList<>(list1.size() + list2.size());
        listAll.addAll(list1);
        listAll.addAll(list2);

        // 去重并集
        List<String> listAllDistinct = listAll.stream().distinct().collect(Collectors.toList());

        System.out.println("done!");
    }

    /**
     * 去重合并
     */
    private static void mergeList() {

        List<String> listA = Lists.newArrayList("a", "b", "c", "d", "e", "f");
        List<String> listB = Lists.newArrayList("d", "e", "f", "g", "h");

        // 第一种 利用set本身不重复的特性
        Set<String> set = new HashSet<String>(listA){{
            addAll(listB);
        }};
        System.out.println(set);

        // 第二种 利用jdk8 stream操作
        List<String> collect = Stream.of(listA, listB)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * jdk7原生操作
     */
    private static void collectionOperationTest() {
        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");

        Set<String> set2 = new HashSet<>();
        set2.add("b");
        set2.add("c");
        set2.add("d");

        // [a]
        set1.removeAll(set2);
        System.out.println("set1.removeAll(set2): " + set1);

        // [] 集合求交集，从set1中 移除 所有set2中不包含的元素
        set1.retainAll(set2);
        System.out.println("set1.retainAll(set2): " + set1);

        // [b] 集合求交集，从set1中 移除 所有set2中不包含的元素
        set1.add("b");
        set1.retainAll(set2);
        System.out.println("set1.retainAll(set2): " + set1);

        // [b, c, d]
        set1.addAll(set2);
        System.out.println("set1.addAll(set2): " + set1);
    }


}
