package com.demo.boot_pro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @EnableTransactionManagement 开启事务管理
 * @EnableAsync 用于异步执行，开启多线程
 * @EnableScheduling 用于定时任务扫描
 * */
@SpringBootApplication
@MapperScan("com.demo.boot_pro.dao")
public class BootProApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BootProApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BootProApplication.class);
	}
	/**
	 * 配置JSP视图解析器
	 * 如果没有配置视图解析器。Spring会使用BeanNameViewResolver，
	 * 通过查找ID与逻辑视图名称匹配且实现了View接口的beans
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver setupViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		/** 设置视图路径的前缀 */
		resolver.setPrefix("/WEB-INF/views/");
		/** 设置视图路径的后缀 */
		resolver.setSuffix(".jsp");
		return resolver;
	}

}
