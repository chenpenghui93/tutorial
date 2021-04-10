package com.example.javabasic.sample.collection;

import java.util.*;
import java.util.stream.*;

/**
 * https://www.geeksforgeeks.org/stream-in-java/
 * Stream API使用流式处理集合数据拿到最终结果
 *
 * @Author cph
 * @Date 2020/1/16
 */
public class StreamTest {
    public static void main(String[] args) {

        //map
        List<Integer> number = Arrays.asList(2, 3, 4, 5);
        List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(square);

        //filter
        List<String> names = Arrays.asList("Reflection", "Collection", "Stream");
        List<String> result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
        System.out.println(result);

        //sorted
        List<String> show = names.stream().sorted().collect(Collectors.toList());
        System.out.println(show);

        //collect
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 2);
        Set<Integer> squareSet = numbers.stream().map(x -> x * x).collect(Collectors.toSet());
        System.out.println(squareSet);

        //forEach
        number.stream().map(x -> x * x).forEach(y -> System.out.println(y));

        //reduce
        int even = number.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);
        System.out.println(even);

        //to list
        String[] arrays = new String[]{"a", "b", "c"};
        List<String> list1 = Stream.of(arrays).collect(Collectors.toList());
        System.out.println("list1: "+list1);

        List<String> list2 = Arrays.asList(arrays);
        System.out.println("list2: " + list2);

        //to array
        String[] array1 = list1.stream().toArray(String[]::new);
        System.out.println("array1: " + Arrays.toString(array1));

        String[] array2 = list1.toArray(new String[list1.size()]);
        System.out.println("array2: " + Arrays.toString(array2));

    }
}
