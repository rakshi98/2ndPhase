package com.virtusa.trainingmanagementsystem.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.trainingmanagementsystem.models.Employee;
import com.virtusa.trainingmanagementsystem.models.Schedule;
import com.virtusa.trainingmanagementsystem.models.Topic;
import com.virtusa.trainingmanagementsystem.repositories.ScheduleRepository;
@Transactional
@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private TopicService topicService;
	
	public Schedule saveSchedule(Schedule schedule,String topicName,int employeeId) 
	{
		
		Topic topic=topicService.getTopicByName(topicName);		
		schedule.setTopic(topic);
	
		Employee employee=employeeService.getEmployeeById(employeeId);
		schedule.setEmployee(employee);	
		
		return scheduleRepository.save(schedule);
	}

	public List<Schedule> getAllSchedules() 
	{
		return scheduleRepository.findAll();
	}

	
	public Schedule getScheduleById(int scheduleId)
	{
		return scheduleRepository.findOne(scheduleId);
	}

	public void deleteSchedule(int scheduleId) 
	{
		scheduleRepository.delete(scheduleId);
	}

	
	  public int updateVenue(int scheduleId,String venue)
	  { 
		  return scheduleRepository.updateVenue(scheduleId, venue); 
		  }
	 
	
		
}
