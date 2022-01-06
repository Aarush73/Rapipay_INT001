package com.rapipay.ACT.mini_project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapipay.ACT.mini_project.bean.Agent;
import com.rapipay.ACT.mini_project.bean.Client;
import com.rapipay.ACT.mini_project.bean.Transaction;
import com.rapipay.ACT.mini_project.dao.ACTDaoAgent;
import com.rapipay.ACT.mini_project.dao.ACTDaoClient;
import com.rapipay.ACT.mini_project.dao.ACTDaoTransaction;

@Service
public class ACTServiceImpl implements ACTService {
	
	@Autowired
	ACTDaoAgent agentDao;
	
	@Autowired
	ACTDaoClient clientDao;
	
	@Autowired
	ACTDaoTransaction txDao; 

	@Override
	public Agent getAgent(int id) {
		return agentDao.findById(id).get();
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
	public Client getClient(int id) {
		return clientDao.findById(id).get();
	}

	@Override
	public Client insertClient(Client client) {
		return clientDao.saveAndFlush(client);
	}

	@Override
	public Object updateClient(Client client, int id) {
		if(clientDao.existsById(id)) {
			Client oldClient = clientDao.findById(id).get();
			
			oldClient.setClientName(client.getClientName() != null ? client.getClientName() : oldClient.getClientName());
			oldClient.setClientState(client.getClientState() != null ? client.getClientState() : oldClient.getClientState());
			oldClient.setClientPassword(client.getClientPassword() != null ? client.getClientPassword() : oldClient.getClientPassword());
			oldClient.setPhoneNumber(client.getPhoneNumber() != 0 ? client.getPhoneNumber() : oldClient.getPhoneNumber());
			oldClient.setWalletBalance(client.getWalletBalance() != 0 ? client.getWalletBalance() : oldClient.getWalletBalance());
		    return clientDao.saveAndFlush(oldClient);
		}
		return "Client Not Found";
	}

	@Override
	public String deleteClient(int id) {
		clientDao.deleteById(id);
		return "Client Deleted";
	}

	@Override
	public Transaction getTransaction(int id) {
		return txDao.findById(id).get();
	}

	@Override
	public Transaction insertTransaction(Transaction tx) {
		return txDao.saveAndFlush(tx);
	}

	@Override
	public Object updateTransaction(Transaction tx, int id) {
		if(txDao.existsById(id)) {
			Transaction oldTx = txDao.findById(id).get();
			
			oldTx.setAgentId(tx.getAgentId() != 0 ? tx.getAgentId() : oldTx.getAgentId());
			oldTx.setClientId(tx.getClientId() != 0 ? tx.getClientId() : oldTx.getClientId());
			oldTx.setAmount(tx.getAmount() != 0 ? tx.getAmount() : oldTx.getAmount());
			oldTx.setTType(tx.getTType() != null ? tx.getTType() : oldTx.getTType());
			oldTx.setTDate(tx.getTDate() != null ? tx.getTDate() : oldTx.getTDate());
		    return txDao.saveAndFlush(oldTx);
		}
		return "Transaction Not Found";
	}

	@Override
	public String deleteTransaction(int id) {
		txDao.deleteById(id);
		return "Transaction Deleted";
	}

	@Override
	public List<Agent> getAllAgent() {
		return agentDao.findAll();
	}

    @Override
	public List<Client> getAllClient() {
		return clientDao.findAll();
	}

	@Override
	public List<Transaction> getAllTransaction() {
		return txDao.findAll();
	}

}
