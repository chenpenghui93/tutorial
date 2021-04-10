package com.example.security.core;

import com.example.security.entity.SelfUserEntity;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * security工具类
 *
 * @author chenpenghui
 * @date 2021-2-19
 */
public class SecurityUtil {

    private SecurityUtil() {
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public static SelfUserEntity getUserInfo() {
        SelfUserEntity userDetails = (SelfUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails;
    }

    /**
     * 获取用户id
     *
     * @return
     */
    public static Long getUserId() {
        return getUserInfo().getUserId();
    }

    /**
     * 获取用户名
     *
     * @return
     */
    public static String getUsername() {
        return getUserInfo().getUsername();
    }
}
