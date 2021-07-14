package com.example.tutorialoss;

import com.aliyun.oss.model.OSSObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: test
 * @author: cph
 * @date: 2021/7/12 14:39
 */
public class Test {
    public static void main(String[] args) {
        OSSObject idfaObject = null;

        Map<Long, List<String>> map = new HashMap<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(idfaObject.getObjectContent()));
            StringBuffer result = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                if (!map.containsKey(array[1])) {
                    map.put(Long.valueOf(array[1]), new ArrayList<>());
                }
                map.get(array[1]).add(array[0]);
            }
            bufferedReader.close();
        } catch (Exception e) {
        }
    }
}
