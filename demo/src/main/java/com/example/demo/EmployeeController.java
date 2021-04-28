package com.example.demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.entities.Employee;
import com.example.demo.interfaces.RepositoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Employee Controller")
@RequestMapping(path="/employees/")
public class EmployeeController {
	
	private RepositoryService repositoryService;	
	
	public EmployeeController(RepositoryService newRepositoryService) {
		repositoryService = newRepositoryService;
	}
	
	@ApiOperation(value = "Fetch an Employee by ID")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Employee recovered", response = Employee.class)
	})
	@RequestMapping(path="{id}", method = RequestMethod.GET)
	public @ResponseBody Employee GetEmployee(@PathVariable long id) {
		return repositoryService.GetEmployee(id);
	}
	
	@ApiOperation(value = "Fetch all Employee")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Employees recovered", response = Employee.class, responseContainer = "List")
	})
	@RequestMapping(path="", method = RequestMethod.GET)
	public @ResponseBody List<Employee> GetAll() {
		return repositoryService.GetAll();
	}
	
	@ApiOperation(value = "Creates a new Employee")
	@RequestMapping(path="", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void AddEmployee(@RequestBody Employee employee) {
		repositoryService.CreateEmployee(employee);
	}
	
	@ApiOperation(value = "Deletes an Employee by ID")
	@RequestMapping(path="{id}", method = RequestMethod.DELETE)
	public @ResponseBody void DeleteEmployee(@PathVariable @ApiParam(value="ID of the Employee") long id) {
		repositoryService.DeleteEmployee(id);
	}
	
	@ApiOperation(value = "Updates an Employee")
	@RequestMapping(path="", method = RequestMethod.PUT)
	public @ResponseBody void UpdateEmployee(@RequestBody Employee employee) {
		repositoryService.UpdateEmployee(employee);
	}
	
}
