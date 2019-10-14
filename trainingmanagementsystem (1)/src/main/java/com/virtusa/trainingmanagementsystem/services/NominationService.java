package com.virtusa.trainingmanagementsystem.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.trainingmanagementsystem.models.Employee;
import com.virtusa.trainingmanagementsystem.models.Nomination;
import com.virtusa.trainingmanagementsystem.models.Schedule;
import com.virtusa.trainingmanagementsystem.models.Topic;
import com.virtusa.trainingmanagementsystem.repositories.NominationRepository;
import com.virtusa.trainingmanagementsystem.repositories.ScheduleRepository;



@Service
public class NominationService {
	@Autowired
	private NominationRepository nominationRepository;
	
	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private TopicService topicService;
	
	@Autowired
	private EmployeeService employeeService;


	public Nomination saveNomination(Nomination nomination,int scheduleId, int employeeId) 
	{
		Employee employee=employeeService.getEmployeeById(employeeId);
		nomination.setEmployee(employee);
		
		//String name=scheduleService.getScheduleById(scheduleId);
		
		nomination.setSchedule(scheduleService.getScheduleById(scheduleId));
		return nominationRepository.save(nomination);
	}
	
	

	public List<Nomination> getAllNominations() 
	{

		return nominationRepository.findAll();
	}

	public void delete(int nominationId) 
	{
	
		 nominationRepository.delete(nominationId);
		
	}
	
	public Nomination getEmployeeById(int employeeId)
	{
	
		
		return nominationRepository.findOne(employeeId);

	}
	

	public List<Nomination> getAllTopics() 
	{
		return nominationRepository.findAll();
	}


}
