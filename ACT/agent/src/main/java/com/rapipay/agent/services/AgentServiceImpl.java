package com.rapipay.agent.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rapipay.agent.bean.Agent;
import com.rapipay.agent.bean.Client;
import com.rapipay.agent.dao.AgentDao;

@Service
public class AgentServiceImpl implements AgentService {
	
	@Autowired
	private AgentDao agentDao;

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Agent getAgent(int id) {
		ArrayList<Client> clients = (ArrayList<Client>) restTemplate.getForObject("http://localhost:7071/client/agent/"+id, ArrayList.class);
		Agent a = agentDao.findById(id).get();
		a.setListClients(clients);
		return agentDao.saveAndFlush(a);
	}

	@Override
	public Agent insertAgent(Agent agent) {	
		return agentDao.saveAndFlush(agent);
	}

	@Override
	public Object updateAgent(Agent agent, int id) {
		if(agentDao.existsById(id)) {
			Agent oldAgent = agentDao.findById(id).get();
			
			oldAgent.setAccountNumber(agent.getAccountNumber() != 0 ? agent.getAccountNumber() : oldAgent.getAccountNumber());
			oldAgent.setAgentName(agent.getAgentName() != null ? agent.getAgentName() : oldAgent.getAgentName());
			oldAgent.setAgentState(agent.getAgentState() != null ? agent.getAgentState() : oldAgent.getAgentState());
			oldAgent.setBankName(agent.getBankName() != null ? agent.getBankName() : oldAgent.getBankName());
		    oldAgent.setPhoneNumber(agent.getPhoneNumber() != 0 ? agent.getPhoneNumber() : oldAgent.getPhoneNumber());
		    oldAgent.setWalletBalance(agent.getWalletBalance() != 0 ? agent.getWalletBalance() : oldAgent.getWalletBalance());
		    return agentDao.saveAndFlush(oldAgent);
		}
		return "Agent Not Found";
	}

	@Override
	public String deleteAgent(int id) {
		agentDao.deleteById(id);
		return "Agent Deleted";
	}

	@Override
	public List<Agent> getAllAgent() {
		return agentDao.findAll();
	}

}

