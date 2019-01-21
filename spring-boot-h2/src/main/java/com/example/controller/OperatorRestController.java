package com.example.controller;

import java.io.IOException;
import java.util.List;

import com.example.entity.Operators;
import com.example.service.impl.OperatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperatorRestController {

	@Autowired
	private OperatorService operatorService;

	@GetMapping("/write/csv")
	public void uploadOperators() throws IOException {
		operatorService.initCSV();
	}

	@GetMapping("/getAllOperator")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Operators> getAllOperators(){
		return operatorService.getAllOperators();
	}  

}