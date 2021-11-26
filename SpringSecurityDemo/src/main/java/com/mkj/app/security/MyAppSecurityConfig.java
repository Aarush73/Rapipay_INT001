package com.mkj.app.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

/*
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
*/
import com.mkj.app.service.AppUserServiceImpl;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;


@EnableWebSecurity
public class MyAppSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.
		 	csrf().disable().cors().disable().
			authorizeRequests().

			antMatchers("/public/**").permitAll().
			antMatchers("/admin/**").hasRole("admin").
			antMatchers("/employee/**").hasAnyRole("admin","employee").
			
			anyRequest().authenticated().and().httpBasic();
			
		
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("=============>> inside config method auth "+userDetailService);
		//auth.userDetailsService(userDetailService);
		auth.authenticationProvider(authenticationProvider());
		System.out.println(auth.toString());
	}

	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
    public UserDetailsService userDetailsService() {
        return new AppUserServiceImpl();
    }
	
	 @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	         
	        return authProvider;
	    }
	
	
	 // For In Memory  
	 
		/*	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		//	return new BCryptPasswordEncoder();
		return NoOpPasswordEncoder.getInstance();
	}
	*/
	
	
}//end class
