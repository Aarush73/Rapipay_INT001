package com.rapipay.agent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rapipay.agent.bean.Agent;

public interface AgentDao extends JpaRepository<Agent, Integer>{

}
