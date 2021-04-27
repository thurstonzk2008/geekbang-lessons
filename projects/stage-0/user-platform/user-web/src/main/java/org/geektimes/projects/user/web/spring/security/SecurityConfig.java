package org.geektimes.projects.user.web.spring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security 配置类
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since TODO
 * Date : 2021-04-24
 */
@Configuration
@Order(10000)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // 开启
//        httpSecurity.csrf();
        httpSecurity.authorizeRequests();
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
//        webSecurity.securityInterceptor()
    }
}