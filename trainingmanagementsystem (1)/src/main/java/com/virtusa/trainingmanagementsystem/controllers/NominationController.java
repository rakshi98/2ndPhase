package com.virtusa.trainingmanagementsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.virtusa.trainingmanagementsystem.models.Employee;
import com.virtusa.trainingmanagementsystem.models.Nomination;
import com.virtusa.trainingmanagementsystem.models.Schedule;
import com.virtusa.trainingmanagementsystem.services.NominationService;
import com.virtusa.trainingmanagementsystem.services.ScheduleService;

@Controller
public class NominationController {
	@Autowired
	private NominationService nominationService;

	@Autowired
	private ScheduleService scheduleService;

	@ModelAttribute("schedules")
	public List<Schedule> getAllSchedules() 
	{
		return scheduleService.getAllSchedules();

	}

	//Employee Nomination
	@GetMapping("/applynomination")
	public String loadNomination() 
	{
		return "employeenomination";
	}

	
	  @PostMapping("/savenominations") public String
	  saveNomination(@ModelAttribute Nomination nomination,@RequestParam String scheduleInfo,Model model,int employeeId)
	  { 
		  String[] data=scheduleInfo.split("-");
		  model.addAttribute("nominations",nominationService.saveNomination(nomination,(Integer.parseInt(data[0])), employeeId));
	  
	  
	  return "redirect:/applynomination"; }
	  
	 
	  //admin will view nomination
	@GetMapping("/getNominations")
	public String findAllNomination(Model model) 
	{
		model.addAttribute("nominationList", nominationService.getAllNominations());
		return "nominationview";

	}
	//projectmanager will view nomination
	
	@GetMapping("/getNominationsmanager")
	public String findAllNominationManager(Model model) 
	{
		model.addAttribute("nominationList", nominationService.getAllNominations());
		return "managernominationview";

	}
	

	
	
	
	
	

	@RequestMapping(value = "delete/{nominationId}", method = RequestMethod.GET)
	public String delete(@PathVariable("nominationId") int nominationId) {
		nominationService.delete(nominationId);
		return "redirect:/nomination";
	}

}
