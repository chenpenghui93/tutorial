package com.example.javabasic.sample.webservice.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * java发送http请求
 * https://blog.csdn.net/guozili1/article/details/53995121
 *
 * @author cph
 * @version 1.0
 * @date 2018/12/25
 */
public class HttpCall {

    public static void main(String[] args) {
        String string = httpRequest("http://www.qq.com", "GET", null);
        System.out.println(string);
    }

    /**
     * 接口文档中应给出
     * 1.接口类型(webservice、restful、？)
     * 2.调用URL
     * 3.请求方式("POST"、"GET")
     * 4.请求参数及示例
     * 5.返回内容及示例
     *
     * @param requestUrl
     * @param requestMethod
     * @param outputString
     * @return
     */
    public static String httpRequest(String requestUrl, String requestMethod, String outputString) {
        StringBuffer buffer = null;
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod(requestMethod);
            connection.connect();
            if (null != outputString) {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(outputString.getBytes("utf-8"));
                outputStream.close();
            }

            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            buffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }

}
