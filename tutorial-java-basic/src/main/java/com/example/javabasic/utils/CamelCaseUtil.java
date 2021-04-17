package com.example.javabasic.utils;

import com.google.common.base.CaseFormat;

/**
 * 驼峰与下划线、连字符转换工具类
 *
 * @author chenpenghui
 * @date 2020-8-29
 */
public class CamelCaseUtil {

    /**
     * 小驼峰转下划线，例 "testData" -> "test_data"
     *
     * @param string
     * @return
     */
    public static String lowerCamel2Underscope(String string) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, string);
    }

    /**
     * 大驼峰转下划线，例 "TestData" -> "test_data"
     *
     * @param string
     * @return
     */
    public static String upperCamel2Underscope(String string) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, string);
    }

    /**
     * 小驼峰转连字符，例 "testData" -> "test-data"
     *
     * @param string
     * @return
     */
    public static String lowerCamel2Hyphen(String string) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, string);
    }

    /**
     * 下划线转小驼峰，例 "test_data" -> "testData"
     *
     * @param string
     * @return
     */
    public static String underscope2LowerCamel(String string) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, string);
    }

    /**
     * 下划线转大驼峰，例 "test_data" -> "TestData"
     *
     * @param string
     * @return
     */
    public static String underscope2UpperCamel(String string) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, string);
    }

    /**
     * 连字符转小驼峰，例 "test-data" -> "testData"
     *
     * @param string
     * @return
     */
    public static String hyphen2LowerCamel(String string) {
        return CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, string);
    }
}
