package com.demo.boot_pro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

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
}
