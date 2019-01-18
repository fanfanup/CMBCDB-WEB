package com.cmbc.liquibase.test;






import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@EnableConfigurationProperties(LiquibaseProperties.class)
public class DataSourceConfig {
	

		@Bean
		public SpringLiquibase liquibase(DataSource dataSource) throws Exception{
			System.out.println("22222");
			SpringLiquibase liquibase=new SpringLiquibase();
			liquibase.setDataSource(dataSource);
			liquibase.setChangeLog("classpath:liquibase/changelog3.xml");
			liquibase.setContexts("development,test,production");
			liquibase.setShouldRun(true);
			return liquibase;
		}


	    
	    


}
