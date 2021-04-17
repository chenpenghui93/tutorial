package com.example.security;

import com.example.security.entity.SysUserEntity;
import com.example.security.entity.SysUserRoleEntity;
import com.example.security.service.SysUserRoleService;
import com.example.security.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SecurityApplicationTests {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 注册
     */
    @Test
    public void contextLoads() {
        // 注册用户
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setUsername("user");
        sysUserEntity.setPassword(bCryptPasswordEncoder.encode("123456"));
        sysUserEntity.setStatus("NORMAL");
        sysUserService.save(sysUserEntity);

        // 分配角色
        SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
        sysUserRoleEntity.setRoleId(2L);
        sysUserRoleEntity.setUserId(sysUserEntity.getUserId());
        sysUserRoleService.save(sysUserRoleEntity);
    }
}
