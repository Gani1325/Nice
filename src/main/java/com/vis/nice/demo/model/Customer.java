package com.vis.nice.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String mobileNumber;
    public String language;
    public Customer(Integer id, String mobileNumber, String name, String language) {
	super();
	this.id = id;
	this.mobileNumber = mobileNumber;
	this.language = language;
    }
    public Customer() {
	super();
	// TODO Auto-generated constructor stub
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    @Override
    public String toString() {
	return "Customer [id=" + id + ", mobileNumber=" + mobileNumber + ", language=" + language
		+ "]";
    }
}
