package com.vis.nice.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vis.nice.demo.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
    
    public Ticket getByTicketID(Integer ticketNumber);
    
    public List<Ticket> getByMobileNumber(String mobileNumber);
	

}
