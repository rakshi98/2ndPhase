package com.virtusa.trainingmanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.virtusa.trainingmanagementsystem.models.Role;

@Transactional 
public interface RoleRepository extends JpaRepository<Role,String>
{ 
	  //custom jpa method

	
	  @Query("SELECT ur FROM Role ur WHERE ur.employees.employeeId = :id")
	  List<Role> getEmployeeRolesById(@Param("id") int id);
	 
	
}