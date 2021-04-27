package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaces.MessageService;

@RestController
public class MessageRestController {
	
	

	@Value("${course.hello}")
	private String helloMessage;
	private Object object;
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	
	@GetMapping("/helloparam")
	public String hello() {
		return helloMessage;
	}
	
	@RequestMapping(path="api/v1/message", method = RequestMethod.GET)
	public String hello2() {
		return helloMessage;
	}
	
	@RequestMapping(path="api/v1/message/error", method = RequestMethod.GET)
	public ResponseEntity<String> hello3() {
		return new ResponseEntity(helloMessage, HttpStatus.FORBIDDEN);
	}
	
	// Las respuestas no son strng, son ResponseEntity del T de lo que se devuelve de la aplicación
	// Se podría hacer return ResponseEntity(message, HttpStatus.CREATED)
	
	

}
