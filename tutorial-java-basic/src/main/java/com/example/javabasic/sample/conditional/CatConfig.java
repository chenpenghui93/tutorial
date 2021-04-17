package com.example.javabasic.sample.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenpenghui
 * @date 2020-12-31
 */
@Configuration
public class CatConfig {

    /**
     * 如果当前容器中包含Animal类型的Bean，
     * 那么Spring IOC容器就不加载带有@ConditionalOnMissingBean注解的Animal类型的Bean
     */
//    @ConditionalOnMissingBean
    @Bean
    public Animal animal() {
        return new Cat();
    }
}
