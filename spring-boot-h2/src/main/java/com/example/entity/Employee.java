package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Employee {

	@Id
	@Min(value = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "EMPLOYEE_NAME")
	@NotNull(message = "employee name cannot be null")
	@NotEmpty(message = "employee name cannot be empty")
	@Size(min = 2, message = "employee name should be atleast 2 characters")
	private String name;

	@Column(name = "EMPLOYEE_SALARY")
	@NotNull(message = "emmployee slary cannot be null")
	private Integer salary;

	@NotNull
	@NotNull(message = "employee department cannot be null")
	@NotEmpty(message = "employee department cannot be empty")
	@Column(name = "DEPARTMENT")
	@Size(min = 10, message = "deepartment name cannot be empty and should be 10 mins characters")
	private String department;

	@NotNull(message="emp email cannot be null")
	@NotEmpty(message="emp email cannot be empty")
	@Email
	private String empEmail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
