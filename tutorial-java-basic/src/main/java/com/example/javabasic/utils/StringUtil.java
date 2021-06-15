package com.example.javabasic.utils;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: 字符串工具类
 */
public class StringUtil {
    /**
     * @description 指定分割符，查询url的queryStringMap。如 www.baidu.com?a=1&b=&c=2,3
     *              指定分割符为"，"，则返回Map：
     *              （a,[1]）,(b,[]),(c,[2,3])
     */
    public static Map<String, List<String>> getQueryParams(String url, String reg) {
        Map<String, List<String>> params = new HashMap<>();
        if ("&".equals(reg) || "?".equals(reg)) {
            throw new RuntimeException("输入的分割符不能为: " + reg);
        }
        String[] urlParts = url.split("\\?");
        if (urlParts.length > 1) {
            String query = urlParts[1];
            for (String param : query.split("&")) {
                String[] pair = param.split("=");
                String key = pair[0];
                String value = "";
                List<String> values = params.computeIfAbsent(key, k -> new ArrayList<>());
                if (pair.length > 1) {
                    value = pair[1];
                    if (null == reg || reg.trim().equals("")) {
                        values.add(value);
                    } else {
                        String[] split = value.split(reg);
                        Collections.addAll(values, split);
                    }
                }
            }
        }
        return params;
    }


    /**
     * @description 获取指定URL的指定查询参数
     */
    public static String getQueryParam(String url, String param) {
        Map<String, List<String>> queryParams = getQueryParams(url, null);
        if (CollectionUtils.isEmpty(queryParams)) {
            return null;
        }
        List<String> list = queryParams.get(param);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String md5(String source) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(source.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("md5算法出现错误！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    /**
     * 驼峰字符串转蛇形字符串
     * @param name 驼峰字符串
     * @return 蛇形字符串
     */
    public static String snakeString(String name) {
        StringBuilder builder = new StringBuilder(name.replace('.', '_'));
        for (int i = 1; i < builder.length() - 1; ++i) {
            if (isUnderscoreRequired(builder.charAt(i - 1), builder.charAt(i), builder.charAt(i + 1))) {
                builder.insert(i++, '_');
            }
        }
        return builder.toString().toLowerCase(Locale.ROOT);
    }

    private static boolean isUnderscoreRequired(char before, char current, char after) {
        return Character.isLowerCase(before) && Character.isUpperCase(current) && Character.isLowerCase(after);
    }

    /**
     * 按照给定字符串的顺序组成网络查询queruString：
     * curDate=xx&currentPage=xx&email=xxx&partnerId=xxx&partnerSecret=xxx&timestamp=xxx
     * @param strings 不定数量的字符串
     * @return 组装完成的字符串
     */
    public static String concatToQueryString(String... strings) {
        List<String> list = Arrays.stream(strings).filter(item -> !StringUtils.isEmpty(item)).collect(Collectors.toList());
        int strCounts = list.size();
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < strCounts; i++) {
            if (i == strCounts - 1) {
                builder.append(list.get(i));
            } else {
                builder.append(list.get(i)).append("&");
            }
        }
        return builder.toString();
    }
}
