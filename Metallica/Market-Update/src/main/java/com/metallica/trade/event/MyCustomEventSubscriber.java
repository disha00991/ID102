package com.metallica.trade.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyCustomEventSubscriber {
     
	@EventListener({MyCustomEvent.class}) 
	public void handleChangeEvents(final MyCustomEvent event) { 
		System.out.println("********** EVENT RECIEVED ************");
		
	}
}
