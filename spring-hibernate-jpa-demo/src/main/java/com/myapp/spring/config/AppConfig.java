package com.myapp.spring.config;

import java.sql.DriverManager;
import java.util.Calendar;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//Entry point class for spring to find where to find the components
@Configuration
@ComponentScan(basePackages="com.myapp.spring")
public class AppConfig {
	
	@Bean
	public Date date() {
		System.out.println("disha");
		return new Date();
	}
	
	@Bean
	public Date date1() {
		System.out.println("dasd");
		return new Date();
	}
	
	@Bean
	public Calendar calendar() {
		return Calendar.getInstance();
	}
	
	//setting up a connection pool
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/hibernatespring");
		dataSource.setUsername("admin");
		dataSource.setPassword("admin");
		return dataSource;		
	}
	
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}
