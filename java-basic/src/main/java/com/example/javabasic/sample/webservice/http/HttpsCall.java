package com.example.javabasic.sample.webservice.http;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * java发送https请求
 * https://blog.csdn.net/guozili1/article/details/53995121
 *
 * @author cph
 * @version 1.0
 * @date 2018/12/25
 */
public class HttpsCall implements X509TrustManager {

    public static void main(String[] args) {
        String string = httpsRequest("https://kyfw.12306.cn/", "GET", null);
        System.out.println(string);
    }

    /**
     * @param requestUrl
     * @param requestMethod
     * @param outputString
     * @return
     */
    public static String httpsRequest(String requestUrl, String requestMethod, String outputString) {
        StringBuffer stringBuffer = null;
        try {
            //创建SSLContext实例
            SSLContext sslContext = SSLContext.getInstance("SSL");
            TrustManager[] trustManager = {(TrustManager) new HttpsCall()};
            //初始化SSLContext对象
            sslContext.init(null, trustManager, new java.security.SecureRandom());
            //获取SSLSocketFactory对象
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            URL url = new URL(requestUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod(requestMethod);
            //设置当前实例使用SSLSocketFactory
            connection.setSSLSocketFactory(sslSocketFactory);
            connection.connect();
            //向服务器端写内容
            if (null != outputString) {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(outputString.getBytes("utf-8"));
                outputStream.close();
            }

            //读取服务端返回内容
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            stringBuffer = new StringBuffer();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }

    /**
     * @param x509Certificates
     * @param s
     * @throws CertificateException
     */
    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    /**
     * @param x509Certificates
     * @param s
     * @throws CertificateException
     */
    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    /**
     * @return
     */
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
