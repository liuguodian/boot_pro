package com.demo.boot_pro.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/11/22 0022.
 */
@CrossOrigin  //跨域 */
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/say")
    public Test say() {
        Test test = new Test();
        return test;
    }
}
class Test{
     private  String id ;
     private int age;
     private  String sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Test() {
        this.id = "sasa";
        this.age = 12;
        this.sex = "asd每次都是";
    }
}