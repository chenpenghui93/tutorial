package com.example.javabasic.sample.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenpenghui
 * @date 2020-12-31
 */
@Configuration
public class DogConfig {

    /**
     * 当Bean Animal的实现类没有被Spring管理时，
     * 那么Spring IOC容器不会加载带有@ConditionalOnBean注解的Bean
     */
    @ConditionalOnBean(Dog.class)
    @Bean
    public Animal animal(){
        return new Dog();
    }
}
