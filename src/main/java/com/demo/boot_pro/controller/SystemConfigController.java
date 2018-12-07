package com.demo.boot_pro.controller;

import com.demo.boot_pro.service.SystemConfigService;
import com.demo.boot_pro.vo.ProResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by DIAN on 2018/12/6.
 */
@RestController
@RequestMapping("/systemConfig")
public class SystemConfigController {
    @Autowired
    private SystemConfigService systemConfigService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ProResponseResult create(@RequestBody Map params) {
        ProResponseResult proResponseResult =systemConfigService.create(params);
        return proResponseResult;
    }
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ProResponseResult getList(@RequestBody Map params) {
        ProResponseResult proResponseResult =systemConfigService.get(params);
        return proResponseResult;
    }
}
