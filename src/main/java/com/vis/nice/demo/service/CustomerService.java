package com.vis.nice.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vis.nice.demo.model.Customer;
import com.vis.nice.demo.model.Ticket;
import com.vis.nice.demo.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer saveCustomerInformation(Customer customer) {
	return customerRepository.save(customer);
    }
    
    public Customer getCustomerDefaultLanguage(String mobileNumber) {
	Optional<Customer> byMobileNumber = customerRepository.getByMobileNumber(mobileNumber);
	if (byMobileNumber.isPresent()) {
	    return byMobileNumber.get();
	}
	return byMobileNumber.orElse(new Customer());

    }
    
    public List<Customer> getAllCustomerInformation() {
    	return customerRepository.findAll();
        }
    
   
    public void updateLanguage(String mobileNumber, String newLanguage) {
    	
    	 
    	    
       // Long parseInt = Long.parseLong(mobileNumber);
		Customer cust = customerRepository.getByMobileNumber(mobileNumber).get();
        cust.setLanguage(newLanguage);
        customerRepository.save(cust);
    }
    
    

}
