package com.myapp.spring.di;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("instance1")
public class GreetingBeanImpl implements GreetingBean {
	
	@Autowired //means that we have a dependency on a bean
	private Date date;
	
	@Autowired
	private Calendar calendar;

	@Override
	public String greeting() {
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		return (hour<12)? "Good morning":"Good noon" + date;
	}

}
