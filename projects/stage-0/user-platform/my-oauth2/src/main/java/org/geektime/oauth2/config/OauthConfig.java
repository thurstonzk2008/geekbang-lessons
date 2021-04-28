package org.geektime.oauth2.config;

import org.geektime.oauth2.authentication.SecurityAuthenticationFailureHandler;
import org.geektime.oauth2.authentication.SecurityAuthenticationSuccessHandler;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-04-28 3:40 下午
 * @Version 1.0
 **/


@EnableWebSecurity
@Order(200)
public class OauthConfig extends WebSecurityConfigurerAdapter {

        @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeRequests(a -> a
                        .antMatchers("/", "/error", "/webjars/**").permitAll()
                        .anyRequest().authenticated()
                )
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                .oauth2Login();
    }

}