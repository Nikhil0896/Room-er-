package com.springboot.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService uds;
	
	@Bean 
	public BCryptPasswordEncoder bcrypt()
	{
		return new BCryptPasswordEncoder();
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
	
		http
			.authorizeRequests()
			.antMatchers("/resources/**" , "/WEB-INFO/jsp/*").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/welcome")
			.failureUrl("/login?error")
			.permitAll()
			.and()
			.logout()
			.permitAll();	
		
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(uds).passwordEncoder(bcrypt());
	}
	

}
