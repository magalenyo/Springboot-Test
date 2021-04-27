package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.entities.Employee;

public interface RepositoryService {

	Employee GetEmployee(Long id);
	void CreateEmployee(Employee employee);
	void DeleteEmployee(Long id);
	void UpdateEmployee(Employee employee);
	List<Employee> GetAll();
}
