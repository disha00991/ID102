package com.myapp.spring;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.myapp.spring.config.AppConfig;
import com.myapp.spring.di.DataSourceBean;
import com.myapp.spring.di.GreetingBean;
import com.myapp.spring.di.MyBean;

public class TestSpringJdbcTemplate {

	public static void main(String[] args) {
		// STEP 1 start the spring container
		AbstractApplicationContext springContainer = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//STEP 2 request for a bean inside a spring container
		DataSourceBean myBean  = springContainer.getBean(DataSourceBean.class);
		
		FlightDAO dao = springContainer.getBean(FlightDAO.class);
		FlightDAOImpl dao1 = springContainer.getBean(FlightDAOImpl.class);
		dao.findAll().forEach(System.out::println);
		
		//STEP 3 close the container
		springContainer.close();
	}

} 