package com.cmbc.liquibase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 * 打成war包，所以需要这个
 */
public class SpringBootStartApplication extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(LiquibaseWebApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(LiquibaseWebApplication.class, args);
    }
	
}
