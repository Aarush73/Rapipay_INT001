package com.dao;

import com.bean.TicketDetails;
import com.main.MainApp;

public class TicketDaoImpl implements TicketDao {

	public void login(String unm, String pwd) {

	}

	public void showTrains() {
		System.out.println(MainApp.trains);
	}

	public void bookTicket(int trainno) {
		System.out.println("Booked Train " + trainno);
	}

	public void cancelTicket(int ticketno) {
		TicketDetails t = MainApp.tickets.get(ticketno - 1);
		System.out.println("Ticket Cancelled with Ticket Number : " + ticketno);
		if (t.getTicketClass() == "AC")
			System.out.println("Cancellation Charge is : 100");
		else
			System.out.println("Cancellation Charge is : 50");
	}
}
