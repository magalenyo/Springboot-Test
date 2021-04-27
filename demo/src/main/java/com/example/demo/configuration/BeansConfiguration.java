package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.EmployeeController;
import com.example.demo.MessageRestControllerV4;
import com.example.demo.interfaces.MessageService;
import com.example.demo.interfaces.MessageServiceDB;
import com.example.demo.interfaces.MessageServiceYAML;
import com.example.demo.interfaces.RepositoryService;
import com.example.demo.interfaces.RepositoryServiceImpl;
import com.example.demo.repositories.DataRepository;

@Configuration
public class BeansConfiguration {

	@Bean("DBMessage")
	public MessageService messageServiceDB() {
		return new MessageServiceDB();
	}
	
	@Bean("YAMLMessage")
	public MessageService messageServiceYAML() {
		return new MessageServiceYAML();
	}
	
	@Bean
	public MessageRestControllerV4 messageRestControllerv4(@Qualifier("DBMessage") MessageService messageService) {
		return new MessageRestControllerV4(messageService);
	}
	
//	@Bean
//	public DataRepository dataRepository() {
//		return new DataRepository();
//	}
	
	@Bean
	public RepositoryService repositoryService(DataRepository dataRepository) {
		return new RepositoryServiceImpl(dataRepository);
	}
	
	@Bean
	public EmployeeController employeeController(RepositoryService repositoryService) {
		return new EmployeeController(repositoryService);
	}
}
