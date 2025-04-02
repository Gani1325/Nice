package com.vis.nice.demo.service;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vis.nice.demo.model.Reporting;
import com.vis.nice.demo.repository.ReportingRepository;

@Service
public class ReportingService {
	
	@Autowired
	private ReportingRepository repository;
	
	public Reporting insertTimeRecord(Reporting reporting) {
//		Duration durationMinutes = Duration.between(reporting.getStartTime(), reporting.getEndTime());
//		long duration = durationMinutes.getSeconds();
//		reporting.setDuration(duration);
		
		repository.save(reporting);
		return reporting;
	}
	
	public List<Reporting> getAllData(){
		return repository.findAll();
	}

}
