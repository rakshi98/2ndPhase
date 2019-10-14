package com.virtusa.trainingmanagementsystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TopicTable")
public class Topic 
{
	@Id
	@Column(name="TopicName",nullable=false,length=50)
	private String topicName;

@ManyToOne
@JoinColumn(name="EmployeeId",nullable=false)
private Employee employee;

public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
}


public String getTopicName() {
	return topicName;
}

public void setTopicName(String topicName) {
	this.topicName = topicName;
}

}
