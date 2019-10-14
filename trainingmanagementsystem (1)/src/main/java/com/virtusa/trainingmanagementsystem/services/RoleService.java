package com.virtusa.trainingmanagementsystem.services;

  import java.util.List;
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Service;
import com.virtusa.trainingmanagementsystem.models.Role;
import com.virtusa.trainingmanagementsystem.repositories.RoleRepository;
  
  
  @Service
  
  public class RoleService 
  {
  
	
	  @Autowired private RoleRepository roleRepository;
	  
	  public List<Role> getEmployeeRolesById(int roleId) { return
	  roleRepository.getEmployeeRolesById(roleId); }
	 
  
  
  
  }
 