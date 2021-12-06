package com.rapipay.client.services;

import java.util.List;

import com.rapipay.client.bean.Client;

public interface ClientService {
	public Client getClient(int id);

	public List<Client> getAllClient();

	public Client insertClient(Client client);

	public Object updateClient(Client client, int id);

	public String deleteClient(int id);

	public List<Client> getClientByAgentId(int id);
}
