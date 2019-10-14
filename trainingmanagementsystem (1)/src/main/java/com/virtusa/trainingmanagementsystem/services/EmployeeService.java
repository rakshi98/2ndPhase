package com.virtusa.trainingmanagementsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtusa.trainingmanagementsystem.models.Employee;

import com.virtusa.trainingmanagementsystem.repositories.EmployeeRepository;

@Service
public class EmployeeService 
{

	@Autowired
	private EmployeeRepository employeeRepository;

	
	public Employee saveEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAllEmployee()
	{
		return employeeRepository.findAll();
	}
	public Employee getEmployeeById(int employeeId )
	{
		return employeeRepository.findOne(employeeId);
	}

}
