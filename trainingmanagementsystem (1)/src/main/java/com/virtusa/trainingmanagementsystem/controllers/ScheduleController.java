package com.virtusa.trainingmanagementsystem.controllers;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.virtusa.trainingmanagementsystem.models.Schedule;
import com.virtusa.trainingmanagementsystem.models.Topic;
import com.virtusa.trainingmanagementsystem.services.ScheduleService;
import com.virtusa.trainingmanagementsystem.services.TopicService;

@Controller
public class ScheduleController 
{
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private TopicService topicService;
	

	@ModelAttribute("topics")
	public List<Topic> getAllTopics()
	{
		return topicService.getAllTopics();

	}	
	
	@ModelAttribute("schedules")
	public List<Schedule> getAllSchedules()
	{
		return scheduleService.getAllSchedules();

	}

	@RequestMapping("/addschedule") 
	public String loadSchedule() 
	{
		return "schedule";
	}

	@PostMapping("/saveschedule")
	public String addSchedule(@ModelAttribute Schedule schedule,
			@RequestParam String topicInfo,@RequestParam int employeeId,Model model)
	{

		String[] data=topicInfo.split("-");

		model.addAttribute("schedule", scheduleService.saveSchedule(schedule,(data[0]),employeeId));

		return "schedule";
		//html page name
	}


	// Admin view the topics in dropdownlist
	@GetMapping("/getschedules")
	public String getAllSchedule(Model model)
	{
		model.addAttribute("scheduleList",scheduleService.getAllSchedules());
		return "scheduleview";
	}

	// Employee viewing the topics in dropdown
	@GetMapping("/getschedulesemployee")
	public String getAllScheduleEmployee(Model model)
	{
		model.addAttribute("scheduleList",scheduleService.getAllSchedules());
		return "employeescheduleview";
	}


	@RequestMapping("/delete")
	public String delete(@RequestParam("delete") String scheduleId) 
	{
		
		try 
		{
			scheduleService.deleteSchedule(Integer.parseInt(scheduleId));
		}
		catch(Exception e)
		{
			return "scheduleerror";
		}
		

		return "redirect:/getschedules";
	}
	
	
	  @RequestMapping("/update")
	  public String updateVenue(@RequestParam String venue,int id,Model model) 
	  {  
		  scheduleService.updateVenue(id,venue); 
		  return "redirect:/getschedules"; 
	  }
	 


}
