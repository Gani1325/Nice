package com.vis.nice.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public Integer ticketID;
    public String mobileNumber;
    public String status;
    public Date issueDate;
    public Date closureDate;
    public String ticketType;
    public Ticket(Integer id, Integer ticketID, String status, Date issueDate, Date closureDate,
	    String ticketType,String mobileNumber) {
	super();
	this.id = id;
	this.ticketID = ticketID;
	this.status = status;
	this.issueDate = issueDate;
	this.closureDate = closureDate;
	this.ticketType = ticketType;
	this.mobileNumber = mobileNumber;
    }
    public Ticket() {
	super();
	// TODO Auto-generated constructor stub
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getTicketID() {
        return ticketID;
    }
    public void setTicketID(Integer ticketID) {
        this.ticketID = ticketID;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    public Date getClosureDate() {
        return closureDate;
    }
    public void setClosureDate(Date closureDate) {
        this.closureDate = closureDate;
    }
    public String getTicketType() {
        return ticketType;
    }
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    
    public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
    @Override
	public String toString() {
		return "Ticket [id=" + id + ", ticketID=" + ticketID + ", mobileNumber=" + mobileNumber + ", status=" + status
				+ ", issueDate=" + issueDate + ", closureDate=" + closureDate + ", ticketType=" + ticketType + "]";
	}
	

	
}
