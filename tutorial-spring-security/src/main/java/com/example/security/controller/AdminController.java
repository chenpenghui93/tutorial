package com.example.security.controller;

import com.example.security.core.ResultUtil;
import com.example.security.core.SecurityUtil;
import com.example.security.entity.SelfUserEntity;
import com.example.security.entity.SysMenuEntity;
import com.example.security.entity.SysRoleEntity;
import com.example.security.entity.SysUserEntity;
import com.example.security.service.SysMenuService;
import com.example.security.service.SysRoleService;
import com.example.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理端
 *
 * @author chenpenghui
 * @date 2021-2-19
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/info")
    public Map<String, Object> userLogin() {
        Map<String, Object> result = new HashMap<>();
        SelfUserEntity userDetails = SecurityUtil.getUserInfo();
        result.put("title", "管理端消息");
        result.put("data", userDetails);
        return ResultUtil.ok(result);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/list")
    public Map<String, Object> list() {
        Map<String, Object> result = new HashMap<>();
        List<SysUserEntity> sysUserEntityList = sysUserService.list();
        result.put("title", "有ADMIN或USER角色可访问");
        result.put("data", sysUserEntityList);
        return ResultUtil.ok(result);
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('USER')")
    @GetMapping("/menuList")
    public Map<String, Object> menuList() {
        Map<String, Object> result = new HashMap<>();
        List<SysMenuEntity> sysMenuEntityList = sysMenuService.list();
        result.put("title", "同时有ADMIN、USER角色可访问");
        result.put("data", sysMenuEntityList);
        return ResultUtil.ok(result);
    }

    @PreAuthorize("hasPermission('/admin/userList', 'sys:user:info')")
    @GetMapping("/userList")
    public Map<String, Object> userList() {
        Map<String, Object> result = new HashMap<>();
        List<SysUserEntity> sysUserEntityList = sysUserService.list();
        result.put("title", "拥有sys:user:info可访问");
        result.put("data", sysUserEntityList);
        return ResultUtil.ok(result);
    }

    @PreAuthorize("hasRole('ADMIN') and hasPermission('/admin/adminRoleList', 'sys:role:info')")
    @GetMapping("/adminRoleList")
    public Map<String, Object> adminRoleList() {
        Map<String, Object> result = new HashMap<>();
        List<SysRoleEntity> sysRoleEntityList = sysRoleService.list();
        result.put("title", "拥有ADMIN角色且拥有sys:role:info权限可访问");
        result.put("data", sysRoleEntityList);
        return ResultUtil.ok(result);
    }

}
