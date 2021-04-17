package com.example.javabasic.sample.webservice.resttemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * RestTemplate方式调用
 *
 * @author cph
 * @date 2019/6/4
 */
public class RestTemplateSample {
    public static void main(String[] args) {
//        getForEntityNoHeader();
//        getForEntityWithHeader();
//        getForEntityWithParam();

        String url = "http://api.avatardata.cn/HistoryToday/LookUp?key=2db70b084f654526bd4e3e6aad003a3a&yue=1&ri=1&type=1&page=1&rows=5";
        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> responseEntity = restTemplate.postForObject(url, String.class);
//        String body = responseEntity.getBody();
//        System.out.println(body);

    }

    /**
     * GET 无参 无须指定header
     */
    private static void getForEntityNoHeader() {
        String url = "http://api.avatardata.cn/HistoryToday/LookUp?key=2db70b084f654526bd4e3e6aad003a3a&yue=1&ri=1&type=1&page=1&rows=5";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        String body = responseEntity.getBody();
        System.out.println(body);
    }

    /**
     * GET 无参 指定header
     */
    private static void getForEntityWithHeader() {
        String url = "http://api.avatardata.cn/HistoryToday/LookUp?key=2db70b084f654526bd4e3e6aad003a3a&yue=1&ri=1&type=1&page=1&rows=5";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, httpEntity);
        String body = responseEntity.getBody();
        System.out.println(body);
    }

    /**
     * GET 有参
     */
    private static void getForEntityWithParam() {
        String url = "http://api.avatardata.cn/HistoryToday/LookUp?key={key}&yue=1&ri=1&type=1&page=1&rows=5";
        RestTemplate restTemplate = new RestTemplate();
        Map params = new HashMap(1);
        params.put("key", "2db70b084f654526bd4e3e6aad003a3a");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, params);
        String body = responseEntity.getBody();
        System.out.println(body);
    }
}
