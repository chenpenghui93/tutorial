package com.example.javabasic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设计思想：基于java反射，不依赖Servlet容器，只对action请求起作用
 *          在action的生命周期中可以被多次调用
 *          可以访问action上下文、值栈中的对象
 *          拦截器可以获取IOC容器中的各个bean(过滤器则不能)，在拦截器里注入一个service可以调用业务逻辑
 * 适用场景：切面处理问题
 * 使用方法：自定义拦截器实现接口HandlerInterceptor
 *          自定义拦截器配置类实现WebMvcConfigurer
 *
 * @author cph
 * @version 1.0.0
 * @date 2019/1/8
 */
//@Configuration
public class AuthInterceptor implements HandlerInterceptor {

    /**
     * 请求被处理之前调用
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("AuthInterceptor.preHandle()=================");
        return true;
    }

    /**
     * 请求被处理，视图渲染之前调用（controller调用之后）
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("AuthInterceptor.postHandle()=================");
    }

    /**
     * 请求结束之后调用
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("AuthInterceptor.afterCompletion()=================");
    }
}
