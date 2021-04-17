package com.example.javabasic.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 工具类
 *
 * @author chenpenghui
 * @date 2020-12-9
 */
public class CommonUtil {

    /**
     * 分割list
     *
     * @param list      需要被截取的集合
     * @param cutLength 需要被截取的长度
     * @return List<List < T>>
     * @description 主要处理oracle中in不能超过一千的问题
     */
    public static <T> List<List<T>> splitList(List<T> list, int cutLength) {

        if (list == null) {
            throw new NullPointerException("传入的集合不能为null");
        }

        if (cutLength <= 0) {
            throw new IllegalArgumentException("截取长度不能小于等于零");
        }
        List<List<T>> groupList = new ArrayList<>();
        if (list.size() <= cutLength) {
            groupList.add(list);
            return groupList;
        }

        int len = list.size();

        int num = len % cutLength == 0 ? len / cutLength : (len / cutLength + 1);

        for (int i = 0; i < num; i++) {
            groupList.add(list.subList(i * cutLength, Math.min((i + 1) * cutLength, len)));
        }
        return groupList;
    }

    /**
     * 提取list中的重复元素
     *
     * @param list
     * @param <E>
     * @return
     */
    public static <E> List<E> duplicateList(List<E> list) {
        return list.stream()
                // 获取元素出现频率的map，键为元素，值为元素出现的次数
                .collect(Collectors.toMap(t -> t, t -> 1, Integer::sum))
                .entrySet()
                .stream()
                // 过滤出元素出现次数大于1的entry
                .filter(t -> t.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
