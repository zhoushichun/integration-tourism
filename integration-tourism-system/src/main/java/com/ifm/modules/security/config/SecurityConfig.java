package com.ifm.modules.security.config;


import com.ifm.comment.config.SecurityProperties;
import com.ifm.modules.security.security.EntryPointUnauthorizedHandler;
import com.ifm.modules.security.security.RestAccessDeniedHandler;
import com.ifm.modules.security.security.TokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity// 这个注解必须加，开启Security
@EnableGlobalMethodSecurity(prePostEnabled = true)//保证post之前的注解可以使用
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    EntryPointUnauthorizedHandler entryPointUnauthorizedHandler;

    @Autowired
    SecurityProperties properties;

    @Autowired
    TokenFilter tokenFilter;

    @Autowired
    RestAccessDeniedHandler restAccessDeniedHandler;

    @Autowired
    UserDetailsService userDetailsService;


    // 密码加密方式
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //先来这里认证一下
    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //下面这行代码是看 密码个用户名是否验证成功 没有的话就走entryPointUnauthorizedHandler，验证成如果没有权限就走(restAccessDeniedHandler)可以进行一些操作
                .exceptionHandling().authenticationEntryPoint(entryPointUnauthorizedHandler).accessDeniedHandler(restAccessDeniedHandler)
                .and()
                .authorizeRequests()
//                .antMatchers("/system/userInfo/login").permitAll()
                .antMatchers("/**").permitAll()
//                .antMatchers("/system/user/register").permitAll()
//                .antMatchers("/system/user/verifyCode").permitAll()
//                .antMatchers("/system/user/login").permitAll()

                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/**/api-docs").permitAll()
                .antMatchers("/doc.html", "/api-docs-ext", "/api-docs").permitAll()

                .antMatchers(HttpMethod.OPTIONS, "/**").anonymous()
                //接下来的所有请求都需要认证
                .anyRequest().authenticated()
                .and()
                .csrf()
                .disable()                      // 禁用 Spring Security 自带的跨域处理
                .sessionManagement()                        // 定制我们自己的 session 策略
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);// 调整为让 Spring Security 不创建和使用 session
        // 这行代码主要是用于JWT验证。
        http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
    }


}
