package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;
import com.example.entity.Operators;

@Repository
public interface OperatorRepository extends JpaRepository<Operators, Long> {

}
