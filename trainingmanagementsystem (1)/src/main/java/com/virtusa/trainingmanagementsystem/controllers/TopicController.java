package com.virtusa.trainingmanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.virtusa.trainingmanagementsystem.models.Topic;
import com.virtusa.trainingmanagementsystem.services.TopicService;

@Controller
public class TopicController {
	@Autowired
	private TopicService topicService;
	
	
	  public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
	
	//Admin will add topic
	@RequestMapping("/addtopic") 
	  public String addTopic() 
	  { 
	  return "topic";
	  }
	
	
	//Employee will post Topic
	@RequestMapping("/addtopicemp") 
	  public String addTopicemp() 
	  { 
	  return "employeetopic";
	  }
	
	//Manager will post Topic
		@RequestMapping("/addtopicmanager") 
		  public String addTopicManager() 
		  { 
		  return "managertopic";
		  }
	 
	
	//Admin adding topic
	@PostMapping("/savetopic")
	public String addTopic(@ModelAttribute Topic topic,@RequestParam int employeeId,Model model)
	{
		Topic topic1=topicService.saveTopic(topic,employeeId);
	
		  model.addAttribute("topic", topicService.saveTopic(topic,employeeId));
		  return "topic";
	}
	
	//Employee adding topic
	@PostMapping("/savetopicemployee")
	public String addTopicEmployee(@ModelAttribute Topic topic,@RequestParam int employeeId,Model model)
	{
		  model.addAttribute("topic", topicService.saveTopic(topic,employeeId));
		  return "topicemp";
	}
	
	//Manager adding topic
		@PostMapping("/savetopicmanager")
		public String addTopicManager(@ModelAttribute Topic topic,@RequestParam int employeeId,Model model)
		{
			  model.addAttribute("topic", topicService.saveTopic(topic,employeeId));
			  return "topicmanger";
		}
		

	@GetMapping("/gettopics")
	public String getAllTopic(Model model)
	{
		model.addAttribute("topicList",topicService.getAllTopics());
		return "topicview";
	}

}