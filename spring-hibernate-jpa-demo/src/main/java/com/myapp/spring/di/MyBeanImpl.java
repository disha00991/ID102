package com.myapp.spring.di;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class MyBeanImpl implements MyBean{
	
	@PostConstruct
	public void initialize() {
		System.out.println("Inside Init");
	}
	
	//autowiring through a constructor
	@Autowired
	public MyBeanImpl(@Qualifier("instance2")GreetingBean greetingBean) {
		this.greetingBean = greetingBean;
	}

	private GreetingBean greetingBean;
	
	public String display() {
		return greetingBean.greeting();
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroyed");
	}
}