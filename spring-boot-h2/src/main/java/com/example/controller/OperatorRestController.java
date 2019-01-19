package com.example.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.exception.EmployeeNotFoundException;
import com.example.repository.EmployeeRepository;
import com.example.service.impl.EmployeeService;
import com.example.service.impl.OperatorService;

@RestController
public class OperatorRestController {

	@Autowired
	private OperatorService operatorService;

	@GetMapping("/write/csv")
	public void uploadOperators() throws IOException {
		operatorService.initCSV();
	}

}