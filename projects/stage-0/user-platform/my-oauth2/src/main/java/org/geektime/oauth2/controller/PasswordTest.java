package org.geektime.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-04-28 3:46 下午
 * @Version 1.0
 **/
@RestController
public class PasswordTest {
    @GetMapping("/")
    public String hello() {
        return "hello, spring security 123";
    }

    @GetMapping("/passwordtest")
    public String passwordTest() {
        return "password Test!";
    }
}
