package com.example.javabasic.sample;

import com.google.common.base.CaseFormat;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author cph
 * @Date 2020/3/25
 */
public class SimpleTest {

    public static void main(String[] args) throws Exception {

        File file = new File("C:\\Users\\Yuanbao\\Downloads\\popularize_imei.zip");
        List<File> fileList = new ArrayList<>();
        fileList.add(file);

        ZipFile zipFile = new ZipFile("D:/splitTest.zip");
        zipFile.createSplitZipFile(fileList, new ZipParameters(), true, 5 * 1024 * 1024);

    }

    /**
     * 递归实现字符串反转
     *
     * @param originStr
     * @return
     */
    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1) {
            return originStr;
        }
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }


    private static void internTest() {
        String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);

        String s3 = new StringBuilder("wor").append("ld").toString();
        System.out.println(s3.intern() == s3);

        String s4 = new StringBuilder("go").append("to").toString();
        System.out.println(s4.intern() == s4);
    }

    private static void regularExpression() {
        String str = "${GATEWAY_APP_ID:57f14042}";
        String regEX = "\\$\\{(\\w+):(\\S+)\\}";
        Pattern pattern = Pattern.compile(regEX);
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
    }

    private static void clazzTypeTest() {
        Map<String, Object> map = new HashMap<>();
        // true
        System.out.println(map instanceof Map);
        // false
        System.out.println(map.getClass().equals(Map.class));
        // false
        System.out.println(map.getClass().getName().equals(Map.class.getName()));

        List<Map<String, Object>> list = new ArrayList<>();
        // true
        System.out.println(list instanceof List);
        // false
        System.out.println(list.getClass().equals(List.class));
    }

    private static void splitTest() {
        String string = "2020-08-18 22:39:07,2020-08-18 22:39:08";
        System.out.println(string.split(",")[0].trim());
        System.out.println(string.split(",")[1].trim());
    }

    private static void caseFormatTest() {
        // 连字符 转 小驼峰 "test-data" -> "testData"
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
        // 下划线 转 小驼峰 "test_data" -> "testData"
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
        // 下划线 转 大驼峰 "test_data" -> "TestData"
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));

        // 小驼峰 转 下划线 test_data
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "testData"));
        // 大驼峰 转 下划线 test_data
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "TestData"));
        // 小驼峰 转 连字符 test-data
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, "testData"));
    }

    private static void regExIP() {
        String ip = "127.0.0.1,192.168.3.4,172.16.95.48,10.19.49.124";
        String regEx = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(ip);
        while (matcher.find()) {
            String result = matcher.group();
            System.out.println(result);
            break;
        }
    }

    private static void testJoin() {
        String s = String.join("--", "java", "is", "magic").concat("!!");
        System.out.println(s);
    }

    private static void testReg() {
        String str1 = "2019-01-01 00:00:00";
        String str2 = "2020-01-01 00:00:00";
        String str3 = "2021-01-01 00:00:00";
        System.out.println(str1.replaceAll("\\:|00|\\.0| ", "").replace("-", ""));
        System.out.println(str2.replaceAll("\\:|00|\\.0| ", "").replace("-", ""));
        System.out.println(str3.replaceAll("\\:|00|\\.0| ", "").replace("-", ""));
    }

    private static void testIntegerRange() {
        Integer i1 = -128;
        Integer i2 = 100;
        Integer i3 = 127;

        Integer i4 = 128;
        Integer i5 = -129;

        Integer integer1 = -128;
        Integer integer2 = 100;
        Integer integer3 = 127;

        Integer integer4 = 128;
        Integer integer5 = -129;

        // true
        System.out.println(i1 == integer1);
        // true
        System.out.println(i1.equals(integer1));
        // true
        System.out.println(i2 == integer2);
        // true
        System.out.println(i2.equals(integer2));
        // true
        System.out.println(i3 == integer3);
        // true
        System.out.println(i3.equals(integer3));
        // fasle
        System.out.println(i4 == integer4);
        // true
        System.out.println(i4.equals(integer4));
        // false
        System.out.println(i5 == integer5);
        // true
        System.out.println(i5.equals(integer5));
    }

    private static void streamTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .filter(item -> item > 3)
                .forEach(System.out::println);
    }

    private static void structureTest() {
        List<Map<String, List<String>>> result = new ArrayList<>();
        List<String> list1 = Arrays.asList("1", "22", "33");
        Map map1 = new HashMap();
        map1.put("menu", list1);
        result.add(map1);
        System.out.println(result);
    }

    private static void String2Integer() {
        String s = "1";
//        Integer integer = Integer.parseInt(s, Integer.MAX_VALUE);
        Integer integer = Integer.parseInt(s);
        System.out.println(integer);
    }

    private static void substringtest() {
        String str = "basic-mqMessages-query";
        //返回起始位置，下标从0开始
        int begin = str.indexOf("-");
        int end = str.lastIndexOf("-");
        String result = str.substring(begin + 1, end);
        System.out.println(result);
    }

    private static void collectionOperationTest() {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");
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

//    private static void myFirstStarterTest() {
//        HelloWorldService service = new HelloWorldService();
//        service.hello();
//    }

    private static void replaceTest() {
        Map map = new HashMap<>();
        map.put("mobile", "[123456789]");
        String str = map.get("mobile").toString().replace("[", "").replace("]", "");
        System.out.println(str);
    }
}
