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

public class TestSpringDI3 {

	public static void main(String[] args) {
		// STEP 1 start the spring container
		AbstractApplicationContext springContainer = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//STEP 2 request for a bean inside a spring container
		DataSourceBean myBean  = springContainer.getBean(DataSourceBean.class);
		
		//creating sql query
		
		try (Connection connection = myBean.getConnection()){
			String sql = "select * from my_orders";
			
			try(Statement statement = connection.createStatement()) {
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getLong(1)+" "+rs.getString(2));
				}
			}
		} catch (SQLException  e) {
			e.printStackTrace();
		}
		
		//closing the spring container
		springContainer.close();
		
		
//		DataSourceBean myBean1  = springContainer.getBean(DataSourceBean.class);
		
	System.out.println(myBean.getConnection());
		
		//STEP 3 close the container
		springContainer.close();
	}

} 