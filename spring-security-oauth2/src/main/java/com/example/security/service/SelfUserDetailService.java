package com.example.security.service;

import com.example.security.entity.SysUserEntity;
import com.example.security.entity.SelfUserEntity;
import com.example.security.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author chenpenghui
 * @date 2021-2-5
 */
@Component
public class SelfUserDetailService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public SelfUserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserEntity sysUserEntity = sysUserService.selectUserByName(username);
        if (sysUserEntity != null) {
            SelfUserEntity selfUserEntity = new SelfUserEntity();
            BeanUtils.copyProperties(sysUserEntity, selfUserEntity);
            return selfUserEntity;
        }
        return null;
    }
}
