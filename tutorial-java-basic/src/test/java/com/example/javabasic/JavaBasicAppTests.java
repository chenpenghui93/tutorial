package com.example.javabasic;

import com.example.javabasic.utils.ConfigTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
class JavaBasicAppTests {

    @Autowired
    private Environment env;

    @Value("${jwt.secret}")
    private String secret;

    @Autowired
    private ConfigTest configTest;

    /**
     * 获取环境变量或系统变量三种方式
     * 1、@Value("${jwt.secret}")
     * 2、environment.getProperty("jwt.secret")
     * 3、@ConfigurationProperties
     */
    @Test
    public void t() {
        System.out.println(secret);
        System.out.println(env.getProperty("jwt.secret"));
        System.out.println(configTest);
    }

}
