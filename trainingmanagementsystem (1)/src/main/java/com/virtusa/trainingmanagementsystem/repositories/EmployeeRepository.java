package com.virtusa.trainingmanagementsystem.repositories;


import org.springframework.data.jpa.repository.JpaRepository;


import com.virtusa.trainingmanagementsystem.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> 
{

	/* Employee getEmployeeRoleByName(String roleName); */
	
	
}
