package com.virtusa.trainingmanagementsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.trainingmanagementsystem.models.Employee;
import com.virtusa.trainingmanagementsystem.models.Feedback;
import com.virtusa.trainingmanagementsystem.models.Nomination;
import com.virtusa.trainingmanagementsystem.models.Topic;
import com.virtusa.trainingmanagementsystem.repositories.FeedbackRepository;

@Service
public class FeedbackService {
	@Autowired
	private  FeedbackRepository feedbackRepository;
	
	@Autowired 
	NominationService nominationService;
	
	@Autowired 
	ScheduleService scheduleService;
	

	
	@Autowired 
	EmployeeService employeeService;
	
		public List<Feedback> getAllFeedbacks() {
	
			return feedbackRepository.findAll();
		}

		
			public List<Feedback> getAllTopics() 
		{
			return feedbackRepository.findAll();
		}


		public Feedback saveFeedback(Feedback feedback,int scheduleId,int employeeId) {
			// TODO Auto-generated method stub
			
			Employee employee=employeeService.getEmployeeById(employeeId);
			feedback.setEmployee(employee);
			
			
			feedback.setSchedule(scheduleService.getScheduleById(scheduleId));
			return feedbackRepository.save(feedback);
			
		}
		
		
		

}
