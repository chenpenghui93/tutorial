package com.example.security.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JWT配置类
 *
 * @author chenpenghui
 * @date 2021-1-22
 */
@Getter
@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTConfig {

    /**
     * 密钥key
     */
    public static String secret;

    /**
     * token key
     */
    public static String tokenHeader;

    /**
     * token前缀字符
     */
    public static String tokenPrefix;

    /**
     * 过期时间
     */
    public static Integer expiration;

    /**
     * 不需要认证的接口
     */
    public static String antMatchers;

    public void setSecret(String secret) {
        JWTConfig.secret = secret;
    }

    public void setTokenHeader(String tokenHeader) {
        JWTConfig.tokenHeader = tokenHeader;
    }

    public void setTokenPrefix(String tokenPrefix) {
        JWTConfig.tokenPrefix = tokenPrefix;
    }

    public void setExpiration(Integer expiration) {
        JWTConfig.expiration = expiration * 1000;
    }

    public void setAntMatchers(String antMatchers) {
        JWTConfig.antMatchers = antMatchers;
    }
}
