package com.example.demo.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Employee Entity")
@Entity
@Table(name = "employees")
public class Employee {
	@javax.persistence.Id
	@ApiModelProperty(value = "Employee Identificator")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@ApiModelProperty(value = "Employee Name")
	private String name;
	@ApiModelProperty(value = "Employee Surname")
	private String surname;
	@ApiModelProperty(value = "Employee Birth Date yyyy-mm-dd", example = "1996-10-20")
	private LocalDate birthDate;
	
	// @Column(name="ColumnName
	// @JsonIgnore para no devlver
	// @DateTimeFormat
	
	public Employee() {}
	
	public Employee(String newName, String newSurname, LocalDate newBirthDate) {
		name = newName;
		surname = newSurname;
		birthDate = newBirthDate;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
