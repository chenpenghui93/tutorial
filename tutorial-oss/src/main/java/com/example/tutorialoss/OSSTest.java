package com.example.tutorialoss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;
import com.opencsv.CSVWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: cph
 * @date: 2021/6/30 21:17
 */
@Slf4j
@RestController
public class OSSTest {

    private static String endpoint = "";
    private static String accessKeyId = "";
    private static String accessKeySercet = "";
    private static String bucket = "";

    public static void main(String[] args) {

        // 初始化客户端
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySercet);
        // 列举文件
        ObjectListing objectListing = ossClient.listObjects(bucket, "a/b/c/");
        // 获取文件列表
        List<OSSObjectSummary> objectSummaries = objectListing.getObjectSummaries();
        String key = objectSummaries.get(1).getKey();
        // 查询文件
        OSSObject object = ossClient.getObject(bucket, key);
        // 拷贝文件
        CopyObjectResult copyObjectResult = ossClient.copyObject(bucket, key, bucket, "test/" + key);
        // 下载到本地文件
        ossClient.getObject(new GetObjectRequest(bucket, key), new File("D:\\" + key.substring(key.lastIndexOf("/") + 1)));

        Map<Long, List<String>> map = new HashMap<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(object.getObjectContent()));
            StringBuffer result = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                if (!map.containsKey(Long.valueOf(array[1]))) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(array[0]);
                    map.put(Long.valueOf(array[1]), list);
                } else {
                    map.get(Long.valueOf(array[1])).add(array[0]);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter("D:/test.txt"));
            map.get(1L).forEach(t -> csvWriter.writeNext(new String[]{t}));
            csvWriter.flush();
            csvWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
