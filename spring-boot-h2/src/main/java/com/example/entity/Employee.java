package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Employee {
	
	@Id
	//Adding hibernate validator
	@NotNull
	@NotEmpty
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "EMPLOYEE_NAME")
	@NotNull
	@NotEmpty
	@Size(min=2,message="name cannot be empty and should be atleast 2 characters")
	private String name;

	@NotNull
	@NotEmpty
	@DecimalMin(value = "4")
	@DecimalMax(value="10")
	@Column(name = "EMPLOYEE_SALARY")
	private Integer salary;

	@NotNull
	@NotEmpty
	@Column(name = "DEPARTMENT")
	@Size(min=10,message="deepartment name cannot be empty and should be 10 mins characters")
	private String department;
	
	@NotNull
	@NotEmpty
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
