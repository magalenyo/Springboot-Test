package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaces.MessageService;

@RequestMapping(path="/")
public class MessageRestControllerV4 {
	
//	@Autowired
	private MessageService messageService;	
	// se puede hacer o bien con autowired y @Services en las otras clases, o con constructor
	
	public MessageRestControllerV4(MessageService newMessageService) {
		messageService = newMessageService;
	}
	
	@GetMapping("api/v4/message")
	public @ResponseBody String helloFromService() {
		return messageService.GetMessage();
	} 
	
}
