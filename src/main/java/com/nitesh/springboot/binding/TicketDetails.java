package com.nitesh.springboot.binding;

import java.util.Date;

import lombok.Data;

@Data
public class TicketDetails {	
	
	private String ticketStatus;
	
	private Double ticketPrice;
	
	private String ticketPNR;
	
	private Date ticketBookingDate;
	
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	private Long contactNumber;
	
	private String to;
	
	private String from;
	
	private String journeyDate;
	
	private Integer ticketCount;

}
