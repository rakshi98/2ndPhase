package com.virtusa.trainingmanagementsystem.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;




@Entity
@Table(name ="ScheduleTable")
public class Schedule {

	// primary key
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ScheduleId")
	private int scheduleId;

	//foreign key from Topic class
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="TopicName",nullable=false)
	private Topic topic;
	 
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	//@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "StartDate")
	private LocalDate startDate;
	
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	//@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "EndDate")
	private LocalDate endDate;

	@Column(name = "Venue", length = 20)
	private String venue;

	@ManyToOne
	@JoinColumn(name="EmployeeId",nullable=false)
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}
}
