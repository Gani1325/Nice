package com.vis.nice.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vis.nice.demo.model.Ticket;
import com.vis.nice.demo.repository.TicketRepository;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    public Ticket addTicket(Ticket ticket) {
	return ticketRepository.save(ticket);

    }

    public Ticket getTicketStatus(Integer ticketNumber) {
	return ticketRepository.getByTicketID(ticketNumber);
    }

    public List<Ticket> getAllTicketInformation() {
	return ticketRepository.findAll();
    }

    public List<Ticket> getUserMobileNumber(String mobileNumber) {
	List<Ticket> bymobileNumber = ticketRepository.getByMobileNumber(mobileNumber);
	if (!bymobileNumber.isEmpty()) {
	    return bymobileNumber;
	}
	return new ArrayList<Ticket>();

    }

}
