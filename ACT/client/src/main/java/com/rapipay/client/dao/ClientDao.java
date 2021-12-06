package com.rapipay.client.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rapipay.client.bean.Client;

public interface ClientDao extends JpaRepository<Client, Integer>{

}
