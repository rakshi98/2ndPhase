package com.virtusa.trainingmanagementsystem.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController 
{

	  @GetMapping("/login")
	  public String login()
	  { 
		  return "login"; 
	  }
	  
	  @GetMapping("/error")
	  public String generalerror(Model model)
	  { 
		  return "error"; 
	  }
	  
	  
	  @GetMapping("/scheduleerror")
	  public String scheduleerror(Model model)
	  {
		  return "scheduleerror"; 
	  }
	
}
