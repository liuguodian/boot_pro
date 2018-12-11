package com.demo.boot_pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DIAN on 2018/12/7.
 */
@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String index(){
        return "/views/index";
    }
}
