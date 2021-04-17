package com.example.security.handler;

import com.example.security.entity.SelfUserEntity;
import com.example.security.entity.SysMenuEntity;
import com.example.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义权限注解验证
 *
 * @author chenpenghui
 * @date 2021-2-5
 */
@Component
public class UserPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private SysUserService sysUserService;

    /**
     * hasPermission鉴权
     *
     * @param authentication 用户身份
     * @param targetUrl      请求路径
     * @param permission     请求路径权限
     * @return boolean 是否通过
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object permission) {

        SelfUserEntity selfUserEntity = (SelfUserEntity) authentication.getPrincipal();
        Set<String> permissions = new HashSet<>();
        List<SysMenuEntity> sysMenuEntityList = sysUserService.selectSysMenuByUserId(selfUserEntity.getUserId());
        for (SysMenuEntity sysMenuEntity : sysMenuEntityList) {
            permissions.add(sysMenuEntity.getPermission());
        }
        if (permissions.contains(permission.toString())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
