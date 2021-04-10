package com.example.security.controller;

import com.example.security.core.ResultUtil;
import com.example.security.entity.SysMenuEntity;
import com.example.security.service.SysMenuService;
import com.example.security.entity.SelfUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenpenghui
 * @date 2021-2-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 普通访问
     *
     * @return
     */
    @GetMapping("/info")
    public Map<String, Object> userLogin() {
        Map<String, Object> result = new HashMap<>();
        SelfUserEntity userDetails = (SelfUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        result.put("title", "用户端信息");
        result.put("data", userDetails);
        return ResultUtil.ok(result);
    }

    /**
     * 权限访问
     *
     * @return
     */
    @PreAuthorize("hasRole('USER') and hasPermission('/user/menuList', 'sys:user:info')")
    @GetMapping("/menuList")
    public Map<String, Object> sysMenuEntity() {
        Map<String, Object> result = new HashMap<>();
        List<SysMenuEntity> sysMenuEntityList = sysMenuService.list();
        result.put("title", "拥有USER角色和sys:user:info权限可以访问");
        result.put("data", sysMenuEntityList);
        return ResultUtil.ok(result);
    }
}
