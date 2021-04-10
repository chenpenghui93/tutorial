package com.example.security.config;

import com.example.security.UserAuthenticationProvider;
import com.example.security.handler.*;
import com.example.security.jwt.JWTAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

/**
 * Spring Security 配置类
 *
 * @author chenpenghui
 * @date 2021-2-7
 */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginFailureHandler loginFailureHandler;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private AuthAccessDeniedHandler authAccessDeniedHandler;
    @Autowired
    private AuthenticationEntryPointHandler authenticationEntryPointHandler;
    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    /**
     * 加密方式
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 自定义 permissionEvaluator
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityExpressionHandler userSecurityExpressionHandler() {
        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        handler.setPermissionEvaluator(new UserPermissionEvaluator());
        return handler;
    }

    /**
     * 配置登录认证逻辑
     *
     * @param auth
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(userAuthenticationProvider);
    }

    /**
     * 配置 security 控制逻辑
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 忽略权限认证的请求或资源(从配置文件中读取)
                .antMatchers(JWTConfig.antMatchers.split(",")).permitAll()
                // 其它的需要的登录认证后才能访问
                .anyRequest().authenticated()
                // 配置未登录自定义处理类
                .and().httpBasic().authenticationEntryPoint(authenticationEntryPointHandler)
                // 配置登录地址
                .and().formLogin().loginProcessingUrl("/login/userLogin")
                // 配置登录成功自定义处理类
                .successHandler(loginSuccessHandler)
                // 配置登录失败自定义处理类
                .failureHandler(loginFailureHandler)
                // 配置登出地址
                .and().logout().logoutUrl("/login/userLogout")
                // 配置登出自定义处理类
                .logoutSuccessHandler(logoutSuccessHandler)
                // 配置没有权限自定义处理类
                .and().exceptionHandling().accessDeniedHandler(authAccessDeniedHandler)
                // 开启跨域
                .and().cors()
                // 取消跨站请求伪造防护
                .and().csrf().disable();
        // 基于 token 不需要 session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 使用缓存
        http.headers().cacheControl();
        // 添加 JWT 过滤器
        http.addFilter(new JWTAuthenticationTokenFilter(authenticationManager()));
    }
}
