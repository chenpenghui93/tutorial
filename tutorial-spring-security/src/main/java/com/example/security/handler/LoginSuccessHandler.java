package com.example.security.handler;

import com.example.security.config.JWTConfig;
import com.example.security.core.ResultUtil;
import com.example.security.entity.SelfUserEntity;
import com.example.security.jwt.JWTTokenUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录成功处理类
 *
 * @author chenpenghui
 * @date 2021-1-22
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        SelfUserEntity selfUserEntity = (SelfUserEntity)authentication.getPrincipal();
        String token = JWTTokenUtil.createAccessToken(selfUserEntity);
        token = JWTConfig.tokenPrefix + token;
        Map<String, Object> result = new HashMap<>();
        result.put("code", "200");
        result.put("msg", "登录成功");
        result.put("token", token);
        ResultUtil.json(response, result);
    }
}
