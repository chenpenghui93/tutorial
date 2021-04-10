package com.example.security;

import com.example.security.entity.SelfUserEntity;
import com.example.security.entity.SysRoleEntity;
import com.example.security.service.SelfUserDetailService;
import com.example.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

/**
 * @author chenpenghui
 * @date 2021-2-5
 */
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private SelfUserDetailService selfUserDetailService;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取表单输入的用户名
        String username = (String) authentication.getPrincipal();
        // 获取表单输入的密码
        String password = (String) authentication.getCredentials();
        // 查询用户是否存在
        SelfUserEntity userInfo = selfUserDetailService.loadUserByUsername(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 判断密码是否正确
        if (!new BCryptPasswordEncoder().matches(password, userInfo.getPassword())) {
            throw new BadCredentialsException("密码不正确");
        }
        // 判断其它信息, 例如用户状态
        if (userInfo.getStatus().equals("PROHIBIT")) {
            throw new LockedException("该用户已被冻结");
        }
        // 角色集合
        HashSet<GrantedAuthority> authorities = new HashSet<>();
        List<SysRoleEntity> sysRoleEntityList = sysUserService.selectSysRoleByUserId(userInfo.getUserId());
        for (SysRoleEntity sysRoleEntity : sysRoleEntityList) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + sysRoleEntity.getRoleName()));
        }
        userInfo.setAuthorities(authorities);
        // 登录处理
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
