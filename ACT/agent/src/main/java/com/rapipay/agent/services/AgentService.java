package com.rapipay.agent.services;

import java.util.List;

import com.rapipay.agent.bean.Agent;

public interface AgentService {

	public Agent getAgent(int id);
	
	public List<Agent> getAllAgent();

	public Agent insertAgent(Agent agent);

	public Object updateAgent(Agent agent, int id);

	public String deleteAgent(int id);

//	public Agent updateAmount(Transaction tx, int id);
}
