package com.main;

import java.util.List;

import com.bean.TicketDetails;
import com.bean.TrainDetails;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {
	
	public static List<TrainDetails> trains = new ArrayList<TrainDetails>();
	public static List<TicketDetails> tickets = new ArrayList<TicketDetails>();
	
	public static void main(String[] args) {
		
		TrainDetails t1 = new TrainDetails(12390,"Lucknow Mail","NDLS","LKO",560.90f);
		TrainDetails t2 = new TrainDetails(12354,"ANVT EXP","ANVT","PNBE",600.00f);
		TrainDetails t3 = new TrainDetails(12394,"Rajdhani","NDLS","Mumbai",2000.90f);
		TrainDetails t4 = new TrainDetails(40581, "Intercity", "GZB", "SRE", 70f);
		
		TicketDetails tc1 = new TicketDetails(1, "SL", "NDLS", "LKO", 2, 1121.80f, 12390);
		TicketDetails tc2 = new TicketDetails(2, "AC", "GZB", "SRE", 1, 70f, 40581);
		
		trains.addAll(Arrays.asList(t1,t2,t3, t4));
		tickets.addAll(Arrays.asList(tc1, tc2));
 	}
}
