package com.virtusa.trainingmanagementsystem.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="FeedbackTable")
public class Feedback implements Serializable
{
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FeedbackId")
	private int feedbackId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="ScheduleId")
	private Schedule schedule;

	//foreign key from Employee class
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="employeeId")
	private Employee employee;

	@Column(name="Comments",nullable=false,length=200)
	private String Comments;

	public int getFeedbackId() 
	{
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) 
	{
		this.feedbackId = feedbackId;
	}

	public Schedule getSchedule() 
	{
		return schedule;
	}

	public void setSchedule(Schedule schedule) 
	{
		this.schedule = schedule;
	}

	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getComments() 
	{
		return Comments;
	}

	public void setComments(String comments) 
	{
		Comments = comments;
	}   

}
