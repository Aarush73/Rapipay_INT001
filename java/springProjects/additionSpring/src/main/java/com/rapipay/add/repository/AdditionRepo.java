package com.rapipay.add.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rapipay.add.entity.Addition;

public interface AdditionRepo extends JpaRepository<Addition, Double>{
	
}
