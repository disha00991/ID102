package com.myapp.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.myapp.spring.config.AppConfig;
import com.myapp.spring.di.GreetingBean;

public class TestSpringDI {

	public static void main(String[] args) {
		// STEP 1 start the spring container
		AbstractApplicationContext springContainer = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//STEP 2 request for a bean inside a spring container
		GreetingBean greetingBean  = springContainer.getBean("instance1", GreetingBean.class);
		System.out.println(greetingBean.greeting());
		
		//STEP 3 close the container
		springContainer.close();
	}

}
