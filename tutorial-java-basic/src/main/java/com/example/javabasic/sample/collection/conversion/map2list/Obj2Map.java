package com.example.javabasic.sample.collection.conversion.map2list;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Object转Map
 *
 * @Author cph
 * @Date 2020/1/12
 */
public class Obj2Map {
    public static void main(String[] args) {

        Student1 s1 = new Student1();
        s1.setId(1L);
        s1.setName1("zhangsan");
        s1.setScore(90);

        //第一种，org.apache.commons.beanutils.BeanUtils中的BeanUtils.describe(Obj)
        //转换后的map会多出[class, className]
        try {
            Map map = BeanUtils.describe(s1);
            System.out.println(map.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //第二种，使用Dozer(JavaBean映射工具库)，http://dozer.sourceforge.net/

        //第三种，使用反射, 属性类型问题？
        try {
            Map<String, String> map = Object2Map(s1);
            System.out.println(map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Object2Map
     *
     * @param obj
     * @return map
     * @throws IllegalAccessException
     */
    private static Map<String, String> Object2Map(Object obj) throws IllegalAccessException {
        Map<String, String> map = new HashMap<>();
        //获取对象类中的所有属性
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            String key = field.getName();
            //获取原访问控制权
            boolean accessFlag = field.isAccessible();
            field.setAccessible(true);
            //获取obj中属性field对应的变量
            Object value = field.get(obj);
            if (value != null) {
                map.put(key, value.toString());
            }
            //恢复访问控制权
            field.setAccessible(accessFlag);
        }
        return map;
    }
}
