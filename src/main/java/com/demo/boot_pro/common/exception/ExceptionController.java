package com.demo.boot_pro.common.exception;

import com.demo.boot_pro.utils.LogUtils;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DIAN on 2019/5/27.
 */
@Controller
@RequestMapping(value="/error")
public class ExceptionController implements ErrorController {

    private LogUtils logger = new LogUtils(this.getClass());
    @Override
    public String getErrorPath() {
        logger.info("出错啦！进入自定义错误控制器");
        return "/error";
    }
    @RequestMapping
    public String error() {
        return getErrorPath();
    }
}
