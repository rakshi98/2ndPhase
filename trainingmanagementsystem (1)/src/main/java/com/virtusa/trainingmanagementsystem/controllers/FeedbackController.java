package com.virtusa.trainingmanagementsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtusa.trainingmanagementsystem.models.Feedback;
import com.virtusa.trainingmanagementsystem.models.Nomination;
import com.virtusa.trainingmanagementsystem.models.Schedule;
import com.virtusa.trainingmanagementsystem.models.Topic;
import com.virtusa.trainingmanagementsystem.services.FeedbackService;
import com.virtusa.trainingmanagementsystem.services.NominationService;
import com.virtusa.trainingmanagementsystem.services.ScheduleService;

@Controller
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired
	private ScheduleService scheduleService;

	
	@ModelAttribute("topics")
	public List<Schedule> getAllSchedules() 
	{
		return scheduleService.getAllSchedules();

	}
	
	@GetMapping("/addfeedback") 
	  public String loadFeedback() 
	  {
		return "employeefeedback";
	  }
	
	@PostMapping("/savefeedback")
	public String addFeedback(@ModelAttribute Feedback feedback,@RequestParam String nominationInfo,Model model,int employeeId)
	{
		String[] data=nominationInfo.split("-");

		model.addAttribute("feedback", feedbackService.saveFeedback(feedback,(Integer.parseInt(data[0])),employeeId));
		  return "redirect:addfeedback";
	}
	
	
	@GetMapping("/getfeedback")
	public String findAllFeedbacks(Model model)
	{
		model.addAttribute("feedbackList",feedbackService.getAllFeedbacks());
		return "feedbackview";
		
	}

}
