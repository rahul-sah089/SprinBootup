package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.websocket.server.PathParam;

import com.example.entity.Operators;
import com.example.service.impl.OperatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Operator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class OperatorRestController {

	@Autowired
	private OperatorService operatorService;

	@GetMapping("/write/csv")
	public void uploadOperators() throws IOException {
		operatorService.initCSV();
	}

	@RequestMapping(value = "/operators", method = RequestMethod.GET)
	public List<Operators> getAllOperators() {
		return operatorService.getAllOperators();
	}

	@GetMapping(value = "/operators/{operatorId}")
	public Operators getOperatorById(@PathVariable(name = "operatorId") Long operatorId) {
		return operatorService.getOperator(operatorId);
	}

	@PostMapping(value = "/operators")
	public Operators postMethodName(@RequestBody Operators operators) {
		return operatorService.saveOperator(operators);
	}

	@DeleteMapping(value = "/operators/{operatorId}")
	public void deleteOperators(@PathVariable(name = "operatorId") Long operatorId) {
		operatorService.deleteEmployee(operatorId);
	}

}