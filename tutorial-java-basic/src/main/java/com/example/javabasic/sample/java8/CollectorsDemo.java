package com.example.javabasic.sample.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenpenghui
 * @date 2020/7/18
 */
public class CollectorsDemo {
    public static void main(String[] args) {
//        averagingDouble();
//        averagingInt();
//        averagingLong();

//        collectingAndThen();
//        counting();
//        joining();
//        maxByAndMinBy();
//
//        summingInt();
//        summingLong();
//        summingDouble();
//
//        streamToList();
//        streamToSet();
//        streamToMap();

        groupingByAndMapping();
    }

    private static void groupingByAndMapping() {
        List<Person> list = Person.getList();
        //Collectors.mapping() 一般用于多重 map and reduce中，第一个参数用于map，第二个参数用于reduce
        Map<Integer, String> nameByAge = list.stream().collect(Collectors.groupingBy(Person::getAge,
                Collectors.mapping(Person::getName, Collectors.joining(","))));
        nameByAge.forEach((k, v) -> System.out.println("key: " + k + " value: " + v));

        // List<Object> 获取Object中的指定属性并转为数组
        String[] array = list.stream().map(Person::getName)
                .collect(Collectors.toList())
                .toArray(new String[list.size()]);
    }

    private static void streamToMap() {
        Map<String, String> map = Stream.of("AA", "BB", "CC").collect(Collectors.toMap(k -> k, v -> v + v));
        map.forEach((k, v) -> System.out.println("key: " + k + " value: " + v));
    }

    private static void streamToSet() {
        Set<String> set = Stream.of("AA", "AA", "BB").collect(Collectors.toSet());
        set.forEach(s -> System.out.println(s));
    }

    private static void streamToList() {
        List<String> list = Stream.of("AA", "BB", "CC").collect(Collectors.toList());
        list.forEach(s -> System.out.println(s));
    }

    private static void summingDouble() {
        List<Double> list = Arrays.asList(340.5, 234.56, 672.76);
        //将流中元素视为double值并计算总和
        Double result = list.stream().collect(Collectors.summingDouble(d -> d));
        System.out.println(result);
    }

    private static void summingLong() {
        List<Long> list = new ArrayList<>();
        list.add((long) 340);
        list.add((long) 240);
        list.add((long) 360);
        //将流中元素视为long值，并计算总和
        Long result = list.stream().collect(Collectors.summingLong(l -> l));
        System.out.println(result);
    }

    private static void summingInt() {
        List<Integer> list = Arrays.asList(30, 10, 20, 35);
        //将流中元素视为int值，并计算总和
        Integer result = list.stream().collect(Collectors.summingInt(i -> i));
        System.out.println(result);
    }

    private static void maxByAndMinBy() {
        List<Integer> list = Arrays.asList(30, 10, 20, 35);
        //计算流中元素的最大值
        list.stream().collect(Collectors.maxBy(new CollectorsDemo().new IntegerImpl()))
                .ifPresent(i -> System.out.println(i));
        //计算流中元素的最小值
        list.stream().collect(Collectors.minBy(new CollectorsDemo().new IntegerImpl()))
                .ifPresent(i -> System.out.println(i));
    }

    /**
     * 拼接元素 Collectors.joining
     */
    private static void joining() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        //用某个指定的拼接字符将流中元素拼接成一个字符串，并添加可选的前缀和后缀
        String result = list.stream().collect(Collectors.joining(",", "(", ")"));
        System.out.println(result);
    }

    private static void counting() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        //统计流中元素个数
        Long result = list.stream().collect(Collectors.counting());
        System.out.println(result);
    }

    /**
     * 对生成的集合进行二次操作 Collectors.collectingAndThen
     */
    private static void collectingAndThen() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        //Collectors.collectingAndThen()类似 map and reduce
        // 先执行第一个函数，再执行第二个函数
        Double result = list.stream().collect(Collectors.collectingAndThen(Collectors.averagingLong(v -> v * 2), s -> s * s));
        System.out.println(result);
    }

    /**
     * 计算均值 Collectors.averagingLong
     */
    private static void averagingLong() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        //将流中元素作为long值计算平均值，返回浮点类型的平均值
        Double result = list.stream().collect(Collectors.averagingLong(d -> d * 2));
        System.out.println(result);
    }

    /**
     * 计算均值 Collectors.averagingInt
     */
    private static void averagingInt() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        //将流中元素作为int值计算平均值，返回浮点类型的平均值
        Double result = list.stream().collect(Collectors.averagingInt(d -> d * 2));
        System.out.println(result);
    }

    /**
     * 计算均值 Collectors.averagingDouble
     */
    private static void averagingDouble() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        //计算流中元素的平均值
        Double result = list.stream().collect(Collectors.averagingDouble(d -> d * 2));
        System.out.println(result);
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public static List<Person> getList() {
            List<Person> list = new ArrayList<>();
            list.add(new Person("Ram", 27));
            list.add(new Person("Shyam", 30));
            list.add(new Person("Shiv", 18));
            list.add(new Person("Mahesh", 20));
            return list;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    class IntegerImpl implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 >= o2) {
                return 1;
            } else {
                return -1;
            }
        }
    }

}
