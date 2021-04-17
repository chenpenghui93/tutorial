package com.example.security.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * Spring Security 用户实体
 *
 * @author chenpenghui
 * @date 2021-1-22
 */
@Data
public class SelfUserEntity implements Serializable, UserDetails {

    private static final long serialVersionUID = 8794333204481802467L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态: NORMAL-正常 PROHIBIT-禁用
     */
    private String status;

    /**
     * 用户角色
     */
    private Collection<GrantedAuthority> authorities;

    /**
     * 账户是否过期
     */
    private boolean isAccountNonExpired = false;

    /**
     * 账户是否被锁定
     */
    private boolean isAccountNonLocked = false;

    /**
     * 证书是否过期
     */
    private boolean isCredentialsNonExpired = false;

    /**
     * 账户是否有效
     */
    private boolean isEnabled = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
