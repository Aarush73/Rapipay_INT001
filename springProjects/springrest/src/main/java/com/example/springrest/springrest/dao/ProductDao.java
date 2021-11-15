package com.example.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springrest.springrest.bean.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

}
