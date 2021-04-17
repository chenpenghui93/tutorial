package com.example.security.handler;

import com.example.security.core.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录失败处理类
 *
 * @author chenpenghui
 * @date 2021-1-22
 */
@Slf4j
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {

        if (e instanceof UsernameNotFoundException) {
            log.info("登录失败" + e.getMessage());
            ResultUtil.json(response, ResultUtil.error(500, "用户名不存在！"));
        }
        if (e instanceof LockedException) {
            log.info("登录失败" + e.getMessage());
            ResultUtil.json(response, ResultUtil.error(500, "用户已被锁定！"));
        }
        if (e instanceof BadCredentialsException) {
            log.info("登录失败" + e.getMessage());
            ResultUtil.json(response, ResultUtil.error(500, "用户名或密码不正确！"));
        }

        ResultUtil.json(response, ResultUtil.error(500, "登录失败"));
    }
}
