package com.vis.nice.demo.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vis.nice.demo.model.Ticket;
import com.vis.nice.demo.model.TicketStatus;
import com.vis.nice.demo.service.TicketService;

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/get-ticket-status")
    public ResponseEntity<Ticket> getTicketStatus(@RequestParam Integer ticketNumber) {

	System.out.println("************ getTicketStatus, ticket number " + ticketNumber);

	if (ticketNumber != null) {
	    Ticket ticketStatus = ticketService.getTicketStatus(ticketNumber);
	    if (ticketStatus != null) {
		return new ResponseEntity<Ticket>(ticketStatus, HttpStatus.OK);
	    }
	    return new ResponseEntity<Ticket>(new Ticket(), HttpStatus.NOT_FOUND);
	} else {
	    return new ResponseEntity<Ticket>(new Ticket(), HttpStatus.BAD_REQUEST);
	}
    }

    @GetMapping("/get-mobileNumber")
    public ResponseEntity<List<Ticket>> getUserInfoByMobileNumber(@RequestParam String mobileNumber) {
	System.out.println("************ getUserInfoByMobileNumber, mobileNumber " + mobileNumber);
	List<Ticket> userMobileNumber = ticketService.getUserMobileNumber(mobileNumber);

	if (!userMobileNumber.isEmpty()) {
	    return new ResponseEntity<List<Ticket>>(userMobileNumber, HttpStatus.OK);
	}

	return new ResponseEntity<List<Ticket>>(new ArrayList<Ticket>(), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/reg-new-ticket")
    public ResponseEntity<Ticket> regNewTicker(@RequestBody Ticket ticket) {

	System.out.println("************ regNewTicker, Ticket " + ticket);

	if (ticket != null) {
	    int randomNumber = getRandomNumber();

	    ticket.setIssueDate(new Date());
	    ticket.setTicketID(randomNumber);
	    Date nextSeventhDay = getNextSeventhDay();
	    ticket.setClosureDate(nextSeventhDay);
	    ticket.setStatus(TicketStatus.OPEN.toString());
	    System.out.println("********ticket ******* " + ticket);

	    Ticket addTicket = ticketService.addTicket(ticket);

	    if (addTicket != null) {
		return new ResponseEntity<Ticket>(addTicket, HttpStatus.OK);
	    }
	    return new ResponseEntity<Ticket>(new Ticket(), HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<Ticket>(new Ticket(), HttpStatus.BAD_REQUEST);

    }

    /**
     * @return
     * 
     */
    private Date getNextSeventhDay() {
	Calendar cal = Calendar.getInstance();
	cal.setTime(new Date());

	cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 7);

	Date myDate = cal.getTime();

	return myDate;

    }

    @GetMapping("/get-ticket-info")
    public List<Ticket> getAllTicketInfo() {
	return ticketService.getAllTicketInformation();
    }

    /**
     * 
     */
    private int getRandomNumber() {
	Random random = new Random();
	int min = 100000; // Minimum 6-digit number
	int max = 999999; // Maximum 6-digit number

	int randomNumber = random.nextInt(max - min + 1) + min;
	return randomNumber;
    }
}
