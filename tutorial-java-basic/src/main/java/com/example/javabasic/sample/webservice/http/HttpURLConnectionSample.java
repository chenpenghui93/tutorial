package com.example.javabasic.sample.webservice.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * HttpURLConnection方式调用
 *
 * @author cph
 * @date 2019/6/4
 */
public class HttpURLConnectionSample {

    public static void main(String[] args) {
        System.out.println(restPost("http://www.qq.com", "GET", null));
    }

    /**
     * HttpURLConnectionDemo
     *
     * @param requestUrl
     * @param requestMethod
     * @param result
     * @return
     */
    public static String restPost(String requestUrl, String requestMethod, String result){

        StringBuffer buffer = null;
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //设置是否向HttpURLConnection输出，post请求参数放在http正文中，故设为true;默认为false
            connection.setDoOutput(true);
            //设置是否从HttpURLConnection读入，默认为true
            connection.setDoInput(true);
            //post请求不能使用缓存
            connection.setUseCaches(false);
            //设定传送的内容类型是可序列化的java对象
            connection.setRequestProperty("Content-type", "application/x-java-serialized-object");
            //设置请求方法
            connection.setRequestMethod(requestMethod);
            connection.connect();

            if (result != null) {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(result.getBytes("utf-8"));
                outputStream.close();
            }

            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            buffer = new StringBuffer();
            String line;
            if ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }

}
