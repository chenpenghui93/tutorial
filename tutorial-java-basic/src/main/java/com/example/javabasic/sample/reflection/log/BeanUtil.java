package com.example.javabasic.sample.reflection.log;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @description: Bean工具类
 * @author: cph
 * @date: 2021/7/30 16:40
 */
public class BeanUtil {

    public static <T> String getChangedFields(T newBean, T oldBean) {
        StringBuilder sb = new StringBuilder();
        Field[] fields = newBean.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(ForUpdate.class)) {
                try {
                    Object newValue = field.get(newBean);
                    Object oldValue = field.get(oldBean);
                    if (!Objects.equals(newValue, oldValue)) {
                        sb.append(field.getAnnotation(ForUpdate.class).filedName());
                        sb.append(", 变更前:");
                        sb.append("[" + oldValue + "]");
                        sb.append(" 变更后:");
                        sb.append("[" + newValue + "]");
                        sb.append("\n");
                        sb.append("<br>");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Bean b1 = Bean.builder()
                .id(1L)
                .name("zhangsan")
                .age(20)
                .build();
        Bean b2 = Bean.builder()
                .id(1L)
                .name("lisi")
                .age(22)
                .build();
        String s = BeanUtil.getChangedFields(b1, b2);
        System.out.println(s);
    }

}
