package org.geektime.oauth2.config;

import org.geektime.oauth2.authentication.SecurityAuthenticationFailureHandler;
import org.geektime.oauth2.authentication.SecurityAuthenticationSuccessHandler;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-04-28 3:40 下午
 * @Version 1.0
 **/


@Component
@Order(198)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/myLogin.html")
                .loginProcessingUrl("/login")
                .successHandler(new SecurityAuthenticationSuccessHandler())
                .failureHandler(new SecurityAuthenticationFailureHandler())
//                 使登录页不设限访问
                .permitAll()
                .and()
                .csrf().disable();
    }

}