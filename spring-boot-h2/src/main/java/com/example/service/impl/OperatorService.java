package com.example.service.impl;

import java.util.List;

import com.example.entity.Operators;

public interface OperatorService {
	
	public void initCSV();

	public List<Operators> getAllOperators();

	public Operators getOperator(Long operatorId);

	public Operators saveOperator(Operators operator);

	public void deleteEmployee(Long operatorId);

	public Operators updateEmployee(Operators operators);
	
}
