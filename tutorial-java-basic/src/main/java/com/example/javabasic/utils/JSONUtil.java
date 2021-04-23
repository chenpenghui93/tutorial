package com.example.javabasic.utils;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * JSON转换工具类
 *
 * @author chenpenghui
 * @date 2018/12/20
 */
public class JSONUtil {

    /**
     * 缩进字符串
     */
    private static String SPACE = "   ";

    /**
     * Java 对象转换为 JSON 字符串
     *
     * @param object
     * @return String
     */
    public static final String toJson(final Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * JSON 字符串解析为 Java 对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return T
     */
    public static final <T> T toObject(final String json, final Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * 生成.json文件
     *
     * @param jsonStr
     * @param filePath
     * @param fileName
     * @return
     */
    public static boolean createJsonFile(String jsonStr, String filePath, String fileName) {

        // 标记是否生成成功
        boolean flag = true;

        // 文件路径
        String fullPath = filePath + File.separator + fileName + ".json";

        try {
            // 保证创建一个新文件
            File file = new File(fullPath);
            // 如果父目录不存在，创建父目录
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            // 如果已存在,删除旧文件
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();

            // 转义单引号，因为JSON串中的字符串类型可以单引号引起来的
            if (jsonStr.contains("'")) {
                jsonStr = jsonStr.replaceAll("'", "\\'");
            }

            // 转义双引号，因为JSON串中的字符串类型可以双引号引起来的
            if (jsonStr.contains("\"")) {
                jsonStr = jsonStr.replaceAll("\"", "\\\"");
            }

            // 转换回车换行符，因为JSON串中字符串不能出现显式的回车换行
            if (jsonStr.contains("\r\n")) {
                jsonStr = jsonStr.replaceAll("\r\n", "\\u000d\\u000a");
            }

            // 转换换行符，因为JSON串中字符串不能出现显式的换行
            if (jsonStr.contains("\n")) {
                jsonStr = jsonStr.replaceAll("\n", "\\u000a");
            }

            // 格式化JSON字符串
            jsonStr = formatJson(jsonStr);

            // 将格式化后的JSON字符串写入文件
            Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            write.write(jsonStr);
            write.flush();
            write.close();
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }

        return flag;
    }

    /**
     * 格式化json字符串
     *
     * @param json
     * @return
     */
    public static String formatJson(String json) {
        StringBuffer result = new StringBuffer();
        int length = json.length();
        int number = 0;
        char key;

        // 遍历输入字符串。
        for (int i = 0; i < length; i++) {
            // 1、获取当前字符。
            key = json.charAt(i);

            // 2、如果当前字符是前方括号、前花括号做如下处理：
            if ((key == '[') || (key == '{')) {
                // 2.1 如果前面还有字符，并且字符为“：”，打印：换行和缩进字符字符串。
                if ((i - 1 > 0) && (json.charAt(i - 1) == ':')) {
                    result.append('\n');
                    result.append(indent(number));
                }

                // 2.2 打印：当前字符。
                result.append(key);

                // 2.3 前方括号、前花括号，的后面必须换行。打印：换行。
                result.append('\n');

                // 2.4 每出现一次前方括号、前花括号；缩进次数增加一次。打印：新行缩进。
                number++;
                result.append(indent(number));

                // 2.5 进行下一次循环。
                continue;
            }

            // 3、如果当前字符是后方括号、后花括号做如下处理：
            if ((key == ']') || (key == '}')) {
                // 3.1 后方括号、后花括号，的前面必须换行。打印：换行。
                result.append('\n');

                // 3.2 每出现一次后方括号、后花括号；缩进次数减少一次。打印：缩进。
                number--;
                result.append(indent(number));

                // 3.3 打印：当前字符。
                result.append(key);

                // 3.4 如果当前字符后面还有字符，并且字符不为“，”，打印：换行。
                if (((i + 1) < length) && (json.charAt(i + 1) != ',')) {
                    result.append('\n');
                }

                // 3.5 继续下一次循环。
                continue;
            }

            // 4、如果当前字符是逗号。逗号后面换行，并缩进，不改变缩进次数。
            if ((key == ',')) {
                result.append(key);
                result.append('\n');
                result.append(indent(number));
                continue;
            }

            result.append(key);
        }

        return result.toString();
    }

    /**
     * 返回指定次数的缩进字符串。每一次缩进三个空格，即SPACE。
     *
     * @param number 缩进次数。
     * @return 指定缩进次数的字符串。
     */
    private static String indent(int number) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < number; i++) {
            result.append(SPACE);
        }
        return result.toString();
    }


}
