package com.vis.nice.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vis.nice.demo.model.Customer;
import com.vis.nice.demo.model.Ticket;
import com.vis.nice.demo.repository.CustomerRepository;
import com.vis.nice.demo.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerRepository customerRepository;

	@PostMapping("/save-user-info")
	public Customer saveCustomerInfor(@RequestBody Customer customer) {
		System.out.println("************ saveCustomerInfor, customer " + customer);

		Optional<Customer> obj = customerRepository.getByMobileNumber(customer.getMobileNumber());
		
		if(obj.isPresent()) {
			obj.get().setLanguage(customer.getLanguage());
			return customerService.saveCustomerInformation(obj.get());
		}
		
		// save the user info
		Customer saveCustomerInformation = customerService.saveCustomerInformation(customer);
		return saveCustomerInformation;
	}

	@GetMapping("/get-user-by-mobile-number")
	public Customer getUserInfoByMobileNumber(@RequestParam String mobileNumber) {
		System.out.println("************ getUserInfoByMobileNumber, mobileNumber " + mobileNumber);
		return customerService.getCustomerDefaultLanguage(mobileNumber);
	}

	@GetMapping("/get-customer-info")
	public List<Customer> getAllCustomerInfo() {
		return customerService.getAllCustomerInformation();
	}

	@GetMapping("/test")
	public String test() {
		return "you have reached app successfully";
	}

	// Handler method to update language
	@PutMapping("/updateLanguage")
	public ResponseEntity<String> updateLanguage(@RequestBody Customer customer) {
		// Your logic to update the language for the user with userId
		// For example, you might call a service to update the language
		customerService.updateLanguage(customer.getMobileNumber(), customer.getLanguage());
		return ResponseEntity.ok("Language updated successfully");
	}
	
	
}
