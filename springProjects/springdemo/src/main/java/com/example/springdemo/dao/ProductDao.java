package com.example.springdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdemo.bean.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

}
