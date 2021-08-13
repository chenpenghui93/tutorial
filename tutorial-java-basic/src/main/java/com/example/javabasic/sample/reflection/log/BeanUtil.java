package com.example.javabasic.sample.reflection.log;

import com.example.javabasic.utils.DateUtil;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Date;
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
                        sb.append(", 变更前:[");

                        if (field.getType() == Date.class) {
                            sb.append(DateUtil.dateToString((Date) oldValue, DateUtil.DEFAULT_DATE_FORMAT));
                        } else {
                            if (oldValue != null && !StringUtils.isEmpty(oldValue.toString().trim())) {
                                sb.append(oldValue);
                            } else {
                                sb.append("无数据");
                            }

                        }
                        sb.append("], 变更后:[");
                        if (field.getType() == Date.class) {
                            sb.append(DateUtil.dateToString((Date) newValue, DateUtil.DEFAULT_DATE_FORMAT));
                        } else {
                            if (newValue != null && !StringUtils.isEmpty(newValue.toString().trim())) {
                                sb.append(newValue);
                            } else {
                                sb.append("无数据");
                            }

                        }
                        sb.append("]<br>");
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
                .name(" ")
                .age(null)
                .date(new Date())
                .build();
        String s = BeanUtil.getChangedFields(b1, b2);
        System.out.println(s);
    }

}
