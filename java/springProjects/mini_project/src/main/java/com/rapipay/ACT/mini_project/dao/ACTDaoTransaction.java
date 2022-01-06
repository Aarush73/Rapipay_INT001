package com.rapipay.ACT.mini_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rapipay.ACT.mini_project.bean.Transaction;

public interface ACTDaoTransaction extends JpaRepository<Transaction, Integer>{

}
