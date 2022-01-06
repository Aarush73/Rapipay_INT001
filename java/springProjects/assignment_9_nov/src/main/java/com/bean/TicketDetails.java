package com.bean;

public class TicketDetails {
	private int ticketId;
	private String ticketClass;
	private String source;
	private String destination;
	private int noOfPsg;
	private float totalAmt;
	private int tNo;
	
	public TicketDetails() {}

	public TicketDetails(int ticketId, String ticketClass, String source, String destination, int noOfPsg,
			float totalAmt, int tNo) {
		super();
		this.ticketId = ticketId;
		this.ticketClass = ticketClass;
		this.source = source;
		this.destination = destination;
		this.noOfPsg = noOfPsg;
		this.totalAmt = totalAmt;
		this.tNo = tNo;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketClass() {
		return ticketClass;
	}

	public void setTicketClass(String ticketClass) {
		this.ticketClass = ticketClass;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNoOfPsg() {
		return noOfPsg;
	}

	public void setNoOfPsg(int noOfPsg) {
		this.noOfPsg = noOfPsg;
	}

	public float getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}

	public int gettNo() {
		return tNo;
	}

	public void settNo(int tNo) {
		this.tNo = tNo;
	}

	@Override
	public String toString() {
		return "TicketDetails [ticketId=" + ticketId + ", ticketClass=" + ticketClass + ", source=" + source
				+ ", destination=" + destination + ", noOfPsg=" + noOfPsg + ", totalAmt=" + totalAmt + ", tNo=" + tNo
				+ "]";
	}
}
