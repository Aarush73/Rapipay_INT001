package com.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

public class MyAspect {
	
	@Before("execution(public void com.dao.TicketDaoImpl.*(...))")
	public void userLogin() {
		System.out.println("User Logged In");
	}
	
	@After("execution(public void com.dao.TicketDaoTmpl.bookTicket(*))")
	public void buyTicket() {
		System.out.println("Ticket Purchased");
	}
	
}
