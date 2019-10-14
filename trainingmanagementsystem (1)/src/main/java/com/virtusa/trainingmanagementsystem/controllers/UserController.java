package com.virtusa.trainingmanagementsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController 
{
	//AdminPortal
	@GetMapping("/adminhome")
	public String adminhome()
	{
		return "adminhome";
	}
    //EmployeePortal
	@GetMapping("/employeehome")
	public String employeehome()
	{
		return "employeehome";
	}
	//ManagerHome
	@GetMapping("/managerhome")
	public String projectmanagerhome()
	{
		return "managerhome";
	}
}
