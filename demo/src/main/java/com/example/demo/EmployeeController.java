package com.example.demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.entities.Employee;
import com.example.demo.interfaces.RepositoryService;

@RequestMapping(path="/employees/")
public class EmployeeController {
	
	private RepositoryService repositoryService;	
	
	public EmployeeController(RepositoryService newRepositoryService) {
		repositoryService = newRepositoryService;
	}
	
	@RequestMapping(path="{id}", method = RequestMethod.GET)
	public @ResponseBody Employee GetEmployee(@PathVariable long id) {
		return repositoryService.GetEmployee(id);
	}
	
	@RequestMapping(path="", method = RequestMethod.GET)
	public @ResponseBody List<Employee> GetAll() {
		return repositoryService.GetAll();
	}
	
//	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path="", method = RequestMethod.POST)
	public @ResponseBody void AddEmployee(@RequestBody Employee employee) {
		repositoryService.CreateEmployee(employee);
	}
	
	@RequestMapping(path="{id}", method = RequestMethod.DELETE)
	public @ResponseBody void DeleteEmployee(@PathVariable long id) {
		repositoryService.DeleteEmployee(id);
	}
	
	@RequestMapping(path="", method = RequestMethod.PUT)
	public @ResponseBody void UpdateEmployee(@RequestBody Employee employee) {
		repositoryService.UpdateEmployee(employee);
	}
	
}
