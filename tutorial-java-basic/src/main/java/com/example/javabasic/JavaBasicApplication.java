package com.example.javabasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class JavaBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaBasicApplication.class, args);
    }

}
