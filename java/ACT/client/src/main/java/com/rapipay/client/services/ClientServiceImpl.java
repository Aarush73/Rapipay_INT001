package com.rapipay.client.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rapipay.client.bean.Client;
import com.rapipay.client.bean.Transaction;
import com.rapipay.client.dao.ClientDao;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public Client getClient(int id) {
		Client c = clientDao.findById(id).get();
		
		ArrayList<Transaction> listTx = restTemplate.getForObject("http://localhost:7072/transaction/client/"+id, ArrayList.class);
		c.setListTx(listTx);
		
		return c;
	}

	@Override
	public Client insertClient(Client client) {
		return clientDao.saveAndFlush(client);
	}

	@Override
	public Object updateClient(Client client, int id) {
		if (clientDao.existsById(id)) {
			Client oldClient = clientDao.findById(id).get();

			oldClient
					.setClientName(client.getClientName() != null ? client.getClientName() : oldClient.getClientName());
			oldClient.setClientState(
					client.getClientState() != null ? client.getClientState() : oldClient.getClientState());
			oldClient.setClientPassword(
					client.getClientPassword() != null ? client.getClientPassword() : oldClient.getClientPassword());
			oldClient.setPhoneNumber(
					client.getPhoneNumber() != 0 ? client.getPhoneNumber() : oldClient.getPhoneNumber());
			oldClient.setWalletBalance(
					client.getWalletBalance() != 0 ? client.getWalletBalance() : oldClient.getWalletBalance());
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
	public List<Client> getAllClient() {
		int id = 1;
		List<Client> allClients = new ArrayList<Client>();
		
		for (Client c : clientDao.findAll()) {
			ArrayList<Transaction> tx = restTemplate.getForObject("http://localhost:7072/transaction/client/"+id, ArrayList.class);
	        c.setListTx(tx);
	        
	        allClients.add(c);
	        id++;
		}
		return allClients;
	}
	
	@Override
	public List<Client> getClientByAgentId(int id) {
		List<Client> list = clientDao.findAll();
		list.stream().filter((client) -> client.getAgentId() == id).forEach((c)->System.out.println(c));
		return list.stream().filter((client) -> client.getAgentId() == id).collect(Collectors.toList());
	}

//	@Override
//	public Client updateAmount(int amount, int id) {
//		Client c = getClient(id);
//		c.setWalletBalance(c.getWalletBalance()+amount);
//		return null;
//	}
}
