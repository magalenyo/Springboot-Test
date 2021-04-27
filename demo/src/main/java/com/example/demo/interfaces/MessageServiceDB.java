package com.example.demo.interfaces;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

public class MessageServiceDB implements MessageService{
	
	@Value("${course.helloFromServiceDB}")
	private String helloMessage;

	public MessageServiceDB(){}
	
	@Override
	public String GetMessage() {
		return helloMessage;
	}

}
