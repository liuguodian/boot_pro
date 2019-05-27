package com.demo.boot_pro.common.springMVC;

import com.demo.boot_pro.common.springMVC.interceptor.SecurityInterceptor;
import com.demo.boot_pro.utils.LogUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by DIAN on 2019/5/27.
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    private LogUtils logger = new LogUtils(this.getClass());

    public static final String SESSION_KEY = "user";

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
        // 排除配置
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/login**");
        // 拦截配置
        addInterceptor.addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
