package com.example.javabasic.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author cph
 * @version 1.0.0
 * @date 2019/1/9
 */
//@Configuration
public class AuthFilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        System.out.println("new FilterRegistrationBean()================");
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthFilter());
        registration.addUrlPatterns("/*");
        registration.setName("authFilter");
        registration.setOrder(1);
        return registration;
    }
}
