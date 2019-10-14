package com.virtusa.trainingmanagementsystem.services;

  import java.util.ArrayList; import java.util.List;
  
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.security.core.GrantedAuthority; import
  org.springframework.security.core.authority.SimpleGrantedAuthority; import
  org.springframework.security.core.userdetails.User.UserBuilder; import
  org.springframework.security.core.userdetails.UserDetails; import
  org.springframework.security.core.userdetails.UserDetailsService; import
  org.springframework.security.core.userdetails.UsernameNotFoundException;
  import org.springframework.stereotype.Service; import
  org.springframework.transaction.annotation.Transactional;

import com.virtusa.trainingmanagementsystem.models.Employee;
  

  
  
  
  @Service("userDetailsService") 
  public class UserDetailsServiceImpl implements   UserDetailsService {
  
  @Autowired private EmployeeService employeeService;
  
  @Autowired private RoleService roleService;
  
  @Transactional(readOnly = true)
  
  @Override public UserDetails loadUserByUsername(String username) throws
  UsernameNotFoundException 
  { 
	  System.out.println("UserName="+username);
  
  Employee employee=this.employeeService.getEmployeeById(Integer.parseInt(username));
  
  System.out.println("Found="+employee.getEmployeeId()+","+employee.getPassword()+","+
		  employee.isEnabled()); 
  
  UserBuilder builder = null; if (employee != null) {
  
  builder =
  org.springframework.security.core.userdetails.User.withUsername(username);
  
  if(employee.isEnabled()) { builder.disabled(false); }
  builder.password(employee.getPassword()); 
  String[] authorities =
  this.roleService.getEmployeeRolesById(Integer.parseInt(username)).stream().map(a ->
  a.getRoleName()).toArray(String[]::new);
  
  System.out.println("Length="+authorities.length);
  builder.authorities(authorities); } 
  else 
  { 
	  throw new
  UsernameNotFoundException("User not found."); } return builder.build();
  
  }
  
  }
  
  
  
  
 