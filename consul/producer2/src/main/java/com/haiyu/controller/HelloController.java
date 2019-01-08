package com.haiyu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: HelloController
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/8/26 13:33
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello consul2";
    }
}
