package com.zhk.springnative.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-06-15 3:22 下午
 * @Version 1.0
 **/
@Controller
public class HelloController {
        @RequestMapping("/hello")
        @ResponseBody
        public String hello(){
            return "springnative hello world";
        }
    }

