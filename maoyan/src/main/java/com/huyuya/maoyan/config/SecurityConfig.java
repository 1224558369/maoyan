package com.huyuya.maoyan.config;

import com.huyuya.maoyan.service.UserDetailService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * @author huyu
 * @version 1.0
 * @date 2021/3/30 16:12
 */
// AOP : 横切
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 启动方法基本得权限认证
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private UserDetailService userService;

    @Override // 授权
    protected void configure(HttpSecurity http) throws Exception {
        // 首页所有人可以访问
        // 功能页 只能 对应 有权限的人 才能访问
        //  antMatchers 授权 请求（“”） . hasRole() 授权的角色
        http.authorizeRequests().antMatchers("/").permitAll();
        // 没有权限默认到登录页面 ，
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login");
        // 注销失败 可能的原因
        http.csrf().disable();
        // 防止get注入
        // 开启 注销功能
        http.logout().logoutSuccessUrl("/");

    }

    // 认证 进行授权
    // 在spring Secutiry 5.0 新增了许多加密方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //  5.0 后必须 加密  passwordEncoder()
        //  withUser 认证  用户名 password 认证密码 roles 认证的 角色
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userService).passwordEncoder(encoder);
    }
}
