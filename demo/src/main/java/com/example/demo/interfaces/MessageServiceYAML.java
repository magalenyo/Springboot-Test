package com.example.demo.interfaces;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

public class MessageServiceYAML implements MessageService{
	
	@Value("${course.helloFromServiceYAML}")
	private String helloMessage;

	public MessageServiceYAML(){}
	
	@Override
	public String GetMessage() {
		return helloMessage;
	}

}
