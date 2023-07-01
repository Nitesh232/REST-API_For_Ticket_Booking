package com.nitesh.springboot.restController;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitesh.springboot.binding.PassangerInfo;
import com.nitesh.springboot.binding.TicketDetails;
import com.nitesh.springboot.constants.ConstantVariables;

@RestController
public class BookTicketRestController {

	
	@PostMapping(value = "/bookTicket", 
				 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
				 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	public ResponseEntity<TicketDetails> bookTicket(@RequestBody PassangerInfo pinfo){
		
		TicketDetails td = new TicketDetails();
		
		BeanUtils.copyProperties(pinfo, td);
		
		td.setTicketBookingDate(new Date());
		td.setTicketPNR(UUID.randomUUID().toString());
		td.setTicketPrice(pinfo.getTicketCount()*123.54);
		
		ConstantVariables cnstVar = new ConstantVariables();
		td.setTicketStatus("Confirmed");
		boolean initialPresent = cnstVar.isInitialPresent(pinfo.getFirstName().toLowerCase().charAt(0));
		System.out.println("Value of initialPresent :: "+ initialPresent);
		if(!initialPresent){
			td.setTicketStatus("Not-Confirmed, Under Waiting");
		}
		
		//td.setTicketStatus("Confirmed");
		
		
		return new ResponseEntity<TicketDetails>(td, HttpStatus.CREATED);
	}
	
}
