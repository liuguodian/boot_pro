package com.demo.boot_pro.controller;

import com.demo.boot_pro.common.springMVC.WebConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DIAN on 2019/5/27.
 */
@Controller
public class HomeController {
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("name", WebConfig.SESSION_KEY);
        return "/views/index";
    }

    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String error(Model model) {

        return "/common/error";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "/views/login";
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> loginPost(String account, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (!"123456".equals(password)) {
            map.put("success", false);
            map.put("message", "密码错误");
            return map;
        }

        // 设置session
        session.setAttribute(WebConfig.SESSION_KEY, account);

        map.put("success", true);
        map.put("message", "登录成功");
        return map;
    }

    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebConfig.SESSION_KEY);
        return "/views/login";
    }
}
