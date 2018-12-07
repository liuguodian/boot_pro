package com.demo.boot_pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DIAN on 2018/11/22 0022.
 */
/*@CrossOrigin  //跨域 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/index")
    public String testJsp(){
        return "index";
    }
}
