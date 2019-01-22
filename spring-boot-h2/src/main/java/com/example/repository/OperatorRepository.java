package com.example.repository;

import com.example.entity.Operators;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OperatorRepository extends JpaRepository<Operators, Long> {

}
