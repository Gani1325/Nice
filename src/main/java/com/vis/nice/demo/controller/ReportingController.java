package com.vis.nice.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vis.nice.demo.model.Reporting;
import com.vis.nice.demo.service.ReportingService;

@RestController
public class ReportingController {
	
	@Autowired
	private ReportingService service;
	
	@GetMapping("/testing")
	public String test() {
		return "Application reached successfully";
	}
	
	@GetMapping("/time-record-data")
	public List<Reporting> getAllDate(){
		return service.getAllData();
	}
	
	
	@PostMapping("/time-record")
	public Reporting insertDateTime(@RequestBody Reporting reporting) {
		System.out.println("reporting  info from ivr "+reporting 	);

		Reporting insertTimeRecord = service.insertTimeRecord(reporting);
		
		return insertTimeRecord;
	}

}
