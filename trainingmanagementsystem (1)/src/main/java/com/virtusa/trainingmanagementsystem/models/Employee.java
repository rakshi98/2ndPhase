package com.virtusa.trainingmanagementsystem.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeTable")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee
{

@Id
@Column(name = "EmployeeId")
private int employeeId;

@Column(name="EmployeeName")
private  String employeeName;

@Column(name = "Password",length = 100)
private String password;

@Column(name="EmailID",length=30)
private String emailId;

@Column( name = "ENABLED")
private boolean enabled;

 

public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public boolean isEnabled() {
return enabled;
}

public void setEnabled(boolean enabled) {
this.enabled = enabled;
}

	/*
	 * @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	 * 
	 * @JoinTable(joinColumns=@JoinColumn(name="employeeId",
	 * referencedColumnName="employeeId"),
	 * inverseJoinColumns=@JoinColumn(name="roleId",referencedColumnName="roleId"))
	 * private List<Role> role;
	 */
   
    @OneToMany(cascade=CascadeType.ALL)
private List<Topic> topic;
   
public int getEmployeeId()
{
return employeeId;
}

public void setEmployeeId(int employeeId)
{
this.employeeId = employeeId;
}

public String getPassword()
{
return password;
}

public void setPassword(String password)
{
this.password = password;
}

public String getEmployeeName()
{
return employeeName;
}

public void setEmployeeName(String employeeName)
{
this.employeeName = employeeName;
}

	/*
	 * public List<Role> getRole() { return role; }
	 * 
	 * public void setRole(List<Role> role) { this.role = role; }
	 */
public List<Topic> getTopic() {
return topic;
}

public void setTopic(List<Topic> topic) {
this.topic = topic;
}

}

