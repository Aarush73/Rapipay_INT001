package com.dao;

public interface TicketDao {
	
	public void login(String unm, String pwd); 

	public void showTrains();

	public void bookTicket(int trainno);

	public void cancelTicket(int ticketno);
}
