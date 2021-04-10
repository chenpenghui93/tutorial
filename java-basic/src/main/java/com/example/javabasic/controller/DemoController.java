package com.example.javabasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpenghui
 * @date 2021-4-10
 */
@RestController
public class DemoController {
    @GetMapping("/hi")
    public String hi(){
        return "hello world!";
    }
}
