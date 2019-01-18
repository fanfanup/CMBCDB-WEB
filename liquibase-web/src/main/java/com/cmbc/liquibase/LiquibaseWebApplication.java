package com.cmbc.liquibase;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;




//@ComponentScan(basePackages={"com.cmbc.liquibase"})//指定spring管理的bean所在的包

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.cmbc.liquibase.mapper")
public class LiquibaseWebApplication {
	private static Logger logger = Logger.getLogger(LiquibaseWebApplication.class);
	//public static ConfigurableApplicationContext ac;
	public static void main(String[] args) {
		logger.info("============= SpringBoot Start Success =============");
		SpringApplication.run(LiquibaseWebApplication.class, args);
		//LiquibaseWebApplication.ac = SpringApplication.run(LiquibaseWebApplication.class, args);
	}

}

