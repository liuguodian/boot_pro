package com.demo.boot_pro.common.springMVC.interceptor;

import com.demo.boot_pro.common.springMVC.WebConfig;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by DIAN on 2019/5/27.
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute(WebConfig.SESSION_KEY) == null) {
            // 跳转登录
            String url = "/login";
            response.sendRedirect(url);
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}
