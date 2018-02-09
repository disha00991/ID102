package com.metallica.trade.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@Configuration
@EnableResourceServer
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsService customUserDetailsService;
	
	@Autowired
	private CustomLogoutSuccessHandler customLogoutSuccessHandler;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().headers().frameOptions().disable().and().authorizeRequests()
				// .antMatchers("/", "/home", "/register",
				// "/login","/save").permitAll().antMatchers("/trade/**").authenticated()
				.antMatchers("/home", "/register", "/login", "/save").permitAll().antMatchers("/**").authenticated()
//				.and()
//                .logout()
//                .logoutUrl("/logout").permitAll()
				.and()
	            .logout().logoutSuccessHandler(customLogoutSuccessHandler).permitAll()
				.and().formLogin().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.parentAuthenticationManager(authenticationManager).userDetailsService(customUserDetailsService);
	}
}
