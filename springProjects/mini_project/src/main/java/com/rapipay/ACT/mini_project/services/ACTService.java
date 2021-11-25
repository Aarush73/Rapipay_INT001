package com.rapipay.ACT.mini_project.services;

import java.util.List;

import com.rapipay.ACT.mini_project.bean.Agent;
import com.rapipay.ACT.mini_project.bean.Client;
import com.rapipay.ACT.mini_project.bean.Transaction;

public interface ACTService {

	public Agent getAgent(int id);
	
	public List<Agent> getAllAgent();

	public Agent insertAgent(Agent agent);

	public Object updateAgent(Agent agent, int id);

	public String deleteAgent(int id);

	
	public Client getClient(int id);
	
	public List<Client> getAllClient();

	public Client insertClient(Client client);

	public Object updateClient(Client client, int id);

	public String deleteClient(int id);
	
	
    public Transaction getTransaction(int id);
    
    public List<Transaction> getAllTransaction();
	
	public Transaction insertTransaction(Transaction tx);
	
	public Object updateTransaction(Transaction tx, int id);
	
	public String deleteTransaction(int id);
}
