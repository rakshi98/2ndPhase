package com.virtusa.trainingmanagementsystem.models;

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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="NominationTable")

public class Nomination
{
	//@GenericGenerator(name = "generator", strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "employee"))
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nominationId", unique = true, nullable = false)
	private int nominationId;
	
	@OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="employeeId")
	private Employee employee;
	
	@Column(name="status")
	private boolean status;
	
	
	public boolean isStatus() {
		return status;
	}

	public int getNominationId() {
		return nominationId;
	}

	public void setNominationId(int nominationId) {
		this.nominationId = nominationId;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="TopicName")
	private Schedule schedule;
	
	public Schedule getSchedule() 
	{
		return schedule;
	}

		
	
	}
