package com.example.demo.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.DataRepository;

public class RepositoryServiceImpl implements RepositoryService {

	private DataRepository repository;
	
	public RepositoryServiceImpl(DataRepository newRepository) {
		repository = newRepository;
	}

	@Override
	public Employee GetEmployee(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void CreateEmployee(Employee employee) {
		repository.save(employee);
	}

	@Override
	public void DeleteEmployee(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void UpdateEmployee(Employee employee) {
		if (repository.existsById(employee.getId())) {
			repository.save(employee);
		}
		else {
			// ERROR TREATMENT
		}
	}

	@Override
	public List<Employee> GetAll() {
		return repository.findAll();
	}
}
