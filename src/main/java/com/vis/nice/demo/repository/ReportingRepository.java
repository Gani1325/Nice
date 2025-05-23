package com.vis.nice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vis.nice.demo.model.Reporting;

@Repository
public interface ReportingRepository extends JpaRepository<Reporting, Integer>{

}
