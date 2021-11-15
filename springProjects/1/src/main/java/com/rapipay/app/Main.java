package com.rapipay.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rapipay.app.model.Product;

public class Main {

	public static void main(String[] args) {
		
		
		// Product p = new Product();
		@SuppressWarnings("resource")
		ApplicationContext spring = new ClassPathXmlApplicationContext("spring-conf.xml");
		
		
		Product p1 = (Product)spring.getBean("laptop-1");
		System.out.println(p1.getProductName()); // null
	
		Product p2 = (Product)spring.getBean("laptop-2");
		System.out.println(p2.getProductName());
		System.out.println(p2.getProductId());
	
	
	}
}