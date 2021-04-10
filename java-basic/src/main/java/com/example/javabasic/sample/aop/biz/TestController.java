package com.example.javabasic.sample.aop.biz;

import com.example.javabasic.sample.aop.annotation.MyLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpenghui
 * @date 2020-9-7
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @MyLog(value = "testValue")
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        try {
            System.out.println("执行业务方法... hello()");
//            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hello " + name;
    }

}
