package com.metallica.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.metallica.trade.model.CustomUserDetails;

@SpringBootApplication
public class SeparateOauthImpl {

	public static void main(String[] args) {
		SpringApplication.run(SeparateOauthImpl.class, args);
	}
}
