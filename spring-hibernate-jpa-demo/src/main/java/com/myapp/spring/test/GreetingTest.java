package com.myapp.spring.test;

import com.myapp.spring.di.GreetingBean;
import com.myapp.spring.di.GreetingBeanImpl;

public class GreetingTest {

	public static void main(String[] args) {
		GreetingBean greet = new GreetingBeanImpl();
		greet.greeting();
	}

}
