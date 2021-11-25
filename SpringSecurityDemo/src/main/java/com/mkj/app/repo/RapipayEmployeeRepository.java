package com.mkj.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkj.app.entity.RapipayEmployee;

@Repository
public interface RapipayEmployeeRepository 
    extends JpaRepository<RapipayEmployee, Integer>
{

}
