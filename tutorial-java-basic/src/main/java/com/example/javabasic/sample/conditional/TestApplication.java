package com.example.javabasic.sample.conditional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 参考 https://blog.csdn.net/weixin_44792004/article/details/103661167
 *
 * @author chenpenghui
 * @date 2020-12-31
 */
@SpringBootApplication
public class TestApplication implements CommandLineRunner {

    @Autowired
    private Animal animal;

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    /**
     * 根据当前环境或者容器情况动态注入Bean，与@Bean配合使用
     * @ConditionalOnMissingBean 判断当前需要注入的Spring容器中是否已包含Bean的实现类，如果有则不注入，没有则注入
     * @ConditionalOnBean 判断当前需要注册的Bean的实现类是否被Spring管理，如果被管理则注入，未被管理则不注入
     */
    @Override
    public void run(String... args) {
        String eat = animal.eat();
        System.out.println(eat);
    }
}
