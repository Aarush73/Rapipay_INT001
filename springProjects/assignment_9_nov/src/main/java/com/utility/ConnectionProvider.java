package com.utility;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConnectionProvider {
	static ApplicationContext spring = new ClassPathXmlApplicationContext("spring-conf.xml");
}
