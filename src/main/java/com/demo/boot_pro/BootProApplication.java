package com.demo.boot_pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @EnableTransactionManagement 开启事务管理
 * @EnableAsync 用于异步执行，开启多线程
 * @EnableScheduling 用于定时任务扫描
 * */
@SpringBootApplication

public class BootProApplication  {

	public static void main(String[] args) {
		SpringApplication.run(BootProApplication.class, args);
	}

}
