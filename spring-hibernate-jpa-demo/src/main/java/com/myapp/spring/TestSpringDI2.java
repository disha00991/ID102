package com.myapp.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.myapp.spring.config.AppConfig;
import com.myapp.spring.di.GreetingBean;
import com.myapp.spring.di.MyBean;

public class TestSpringDI2 {

	public static void main(String[] args) {
		// STEP 1 start the spring container
		AbstractApplicationContext springContainer = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//STEP 2 request for a bean inside a spring container
		MyBean myBean  = springContainer.getBean(MyBean.class);
		
		MyBean myBean1  = springContainer.getBean(MyBean.class);
		
		System.out.println("$$$$"+(myBean == myBean1));//default type that is created is the singleton object
		System.out.println(myBean.display());		
		
		//STEP 3 close the container
		springContainer.close();
	}

} 
