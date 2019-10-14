package com.virtusa.trainingmanagementsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.trainingmanagementsystem.models.Employee;
import com.virtusa.trainingmanagementsystem.models.Topic;
import com.virtusa.trainingmanagementsystem.repositories.TopicRepository;

@Service
public class TopicService 
{
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private EmployeeService employeeService;

	public Topic saveTopic(Topic topic,int employeeId) {

		Employee employee=employeeService.getEmployeeById(employeeId);	
		topic.setEmployee(employee);	
	
		return topicRepository.save(topic);
	}

	public List<Topic> getAllTopics() {
		
		return topicRepository.findAll();
	}

	
	public Topic getTopicByName(String topicName)
	{
		return topicRepository.findOne(topicName);
		
	}

}
