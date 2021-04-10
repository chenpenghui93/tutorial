package com.example.security.handler;

import com.example.security.core.ResultUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 未登录处理类
 *
 * @author chenpenghui
 * @date 2021-1-22
 */
@Component
public class AuthenticationEntryPointHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        ResultUtil.json(response, ResultUtil.error(401, "未登录"));
    }
}
