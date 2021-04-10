package com.example.javabasic.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 通过实现接口WebMvcConfigurer添加拦截器
 *
 * @author cph
 * @version 1.0.0
 * @date 2019/1/8
 */
//@Configuration
public class AuthInterceptorConfig implements WebMvcConfigurer {

    /**
     * 实例化自定义拦截器类
     *
     * @return
     */
    AuthInterceptor springMVCInterceptor() {
        System.out.println("new AuthInterceptor()============");
        return new AuthInterceptor();
    }

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("registry.addInterceptor()=========");
        registry.addInterceptor(springMVCInterceptor());
    }


}
