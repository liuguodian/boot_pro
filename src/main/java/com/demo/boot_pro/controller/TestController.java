package com.demo.boot_pro.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/11/22 0022.
 */
/*@CrossOrigin  //跨域 */
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}
