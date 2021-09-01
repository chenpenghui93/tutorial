package com.example.javabasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class JavaBasicApp {

    public static void main(String[] args) {
        SpringApplication.run(JavaBasicApp.class, args);
    }

}
