package com.mkj.app.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import com.mkj.app.service.AppUserServiceImpl;


@EnableWebSecurity
public class MyAppSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().cors().disable().
		
		authorizeRequests().
		
		antMatchers("/public/**").permitAll().
		antMatchers("/admin/**").hasRole("admin").
		antMatchers("/employee/**").hasAnyRole("employee","admin").
		
		and().
		formLogin().and().httpBasic();

	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("=============>> inside config method auth "+userDetailService);
		auth.userDetailsService(userDetailService);
	}


	@Bean
	public UserDetailsService userDeatilsService(DataSource datasource)
	{
		return new JdbcUserDetailsManager(datasource);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		//	return new BCryptPasswordEncoder();
		return NoOpPasswordEncoder.getInstance();
	}
	
	
}//end class
