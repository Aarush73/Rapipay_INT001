package com.rapipay.agent.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rapipay.agent.bean.Agent;
import com.rapipay.agent.bean.Client;
import com.rapipay.agent.bean.Transaction;
import com.rapipay.agent.dao.AgentDao;

@Service
public class AgentServiceImpl implements AgentService {
	
	@Autowired
	private AgentDao agentDao;

	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public Agent getAgent(int id) {
		Agent a = agentDao.findById(id).get();
		
		ArrayList<Client> clients = restTemplate.getForObject("http://localhost:7071/client/agent/"+id, ArrayList.class);
		a.setListClients(clients);
		
		ArrayList<Transaction> tx = restTemplate.getForObject("http://localhost:7072/transaction/agent/"+id, ArrayList.class);
        a.setListTx(tx);
        
        return a;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Agent> getAllAgent() {
		int id = 1;
		List<Agent> allAgents = new ArrayList<Agent>();
		
		for (Agent a : agentDao.findAll()) {
			ArrayList<Client> clients = restTemplate.getForObject("http://localhost:7071/client/agent/"+id, ArrayList.class);
			a.setListClients(clients);
			
			ArrayList<Transaction> tx = restTemplate.getForObject("http://localhost:7072/transaction/agent/"+id, ArrayList.class);
	        a.setListTx(tx);
	        
	        allAgents.add(a);
	        id++;
		}
		return allAgents;
	}

//	@Override
//	public Agent updateAmount(Transaction tx, int id) {
//		Agent a = getAgent(id);
//		a.setWalletBalance(a.getWalletBalance()-tx.getAmount());
//		return agentDao.save(a);
//	}

}

