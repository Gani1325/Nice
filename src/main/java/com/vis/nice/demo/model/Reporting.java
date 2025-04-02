package com.vis.nice.demo.model;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reporting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	
	public LocalDate date;
	public LocalTime startTime;
	public LocalTime endTime;
	public String duration;
	
	@Column(length = 1024)
	public String tranverse_path;
	public long routedAgentSkill;
	
	
	public Reporting() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reporting(Integer id, LocalDate date, LocalTime startTime, LocalTime endTime, String duration, String tranverse_path,long routedAgentSkill) {
		super();
		this.id = id;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.tranverse_path=tranverse_path;
		this.routedAgentSkill=routedAgentSkill;
	}


	public Integer getId() {
		return id;
	}


	public LocalDate getDate() {
		return date;
	}


	public LocalTime getStartTime() {
		return startTime;
	}


	public LocalTime getEndTime() {
		return endTime;
	}


	public String getDuration() {
		return duration;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}


	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	@Override
	public String toString() {
		return "Reporting [id=" + id + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", duration=" + duration + ", tranverse_path=" + tranverse_path + ", routedAgentSkill="
				+ routedAgentSkill + "]";
	}


	


	public String getTranverse_path() {
		return tranverse_path;
	}


	public long getRoutedAgentSkill() {
		return routedAgentSkill;
	}


	public void setTranverse_path(String tranverse_path) {
		this.tranverse_path = tranverse_path;
	}


	public void setRoutedAgentSkill(long routedAgentSkill) {
		this.routedAgentSkill = routedAgentSkill;
	}


	
}
