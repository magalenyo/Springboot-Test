package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(path = "/api/v2")
public class MessageRestControllerV2 {
	@Value("${course.hello}")
	private String helloMessage;
	
	
	@RequestMapping(path="/message", method = RequestMethod.GET)
	public String hello2() {
		return helloMessage;
	}
	
//	@ResponseStatus(HttpStatus.BAD_REQUEST, reason = "Some parameters are invalid")
	@RequestMapping(path="/message/error", method = RequestMethod.GET)
	public String hello3() {
		return helloMessage;
	}
}
