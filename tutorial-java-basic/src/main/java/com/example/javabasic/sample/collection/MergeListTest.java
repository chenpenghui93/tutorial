package com.example.javabasic.sample.collection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream 去重合并
 *
 * @author chenpenghui
 * @date 2021-3-31
 */
public class MergeListTest {
    public static void main(String[] args) {
        String[] arr1 = {"a", "b", "c", "d", "e", "f"};
        List<String> listA = new ArrayList<>(Arrays.asList(arr1));

        String[] arr2 = {"d", "e", "f", "g", "h"};
        List<String> listB = new ArrayList<>(Arrays.asList(arr2));

        Set<String> set = new HashSet<>(listA);
        set.addAll(listB);
        List<String> list = new ArrayList<>(set);
        System.out.println(list);

        List<String> collect = Stream.of(listA, listB)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);

    }
}
