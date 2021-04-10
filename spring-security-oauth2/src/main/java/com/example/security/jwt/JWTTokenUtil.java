package com.example.security.jwt;

import com.alibaba.fastjson.JSON;
import com.example.security.config.JWTConfig;
import com.example.security.entity.SelfUserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * JWT工具类
 *
 * @author chenpenghui
 * @date 2021-1-22
 */
@Slf4j
public class JWTTokenUtil {

    /**
     * 生成token
     *
     * @param selfUserEntity
     * @return
     */
    public static String createAccessToken(SelfUserEntity selfUserEntity) {
        // 登录成功生成token
        String token = Jwts.builder()
                // 用户id
                .setId(selfUserEntity.getUserId().toString())
                // 用户名
                .setSubject(selfUserEntity.getUsername())
                // 签发时间
                .setIssuedAt(new Date())
                // 签发者
                .setIssuer("cph")
                // 自定义属性 用户拥有的权限
                .claim("authorities", JSON.toJSONString(selfUserEntity.getAuthorities()))
                // 失效时间
                .setExpiration(new Date(System.currentTimeMillis() + JWTConfig.expiration))
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, JWTConfig.secret)
                .compact();
        return token;
    }

    /**
     * 私有构造器
     */
    private JWTTokenUtil() {
    }
}
