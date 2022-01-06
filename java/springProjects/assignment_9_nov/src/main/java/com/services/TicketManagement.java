package com.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.TicketDao;

public class TicketManagement {
	
	@Autowired
	TicketDao tdao; 
	
	public void showTrains() {
	    tdao.showTrains(); 
	}
	
	public void bookTicket() {
		tdao.bookTicket(40581);
	}
	
	public void cancelTicket() {
		tdao.cancelTicket(1);
	}

}
