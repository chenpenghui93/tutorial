package com.example.javabasic.sample.outside;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * @description: 头条接口测试
 * @author: cph
 * @date: 2021/7/19 16:41
 */
public class ToutiaoTest {

    public static void main(String[] args) {
        String access_token = "";

        // 请求地址
        String open_api_url_prefix = "https://ad.oceanengine.com/open_api/2/";
        String uri = "dmp/data_source/file/upload/";

        String image_file = "C:\\Users\\Yuanbao\\Downloads\\popularize_imei.zip";

        // 构造请求
        HttpPost httpPost = new HttpPost(open_api_url_prefix + uri);
//        httpPost.setHeader("Content-Type", "multipart/form-data");
        httpPost.setHeader("Access-Token", access_token);
        httpPost.setHeader("X-Debug-Mode", "1");
        // 文件参数
        FileBody file = new FileBody(new File(image_file));
        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create()
                .addPart("file", file);

        // 其他参数
        entityBuilder.addTextBody("advertiser_id", "");
        HttpEntity entity = entityBuilder.build();

        CloseableHttpResponse response = null;
        CloseableHttpClient client = null;

        try {
            client = HttpClientBuilder.create().build();
            httpPost.setURI(URI.create(open_api_url_prefix + uri));

            httpPost.setEntity(entity);

            response = client.execute(httpPost);
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                StringBuffer result = new StringBuffer();
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result.append(line);
                }
                System.out.println(result);
                bufferedReader.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
