package com.fidelity.integration;

import java.util.List;

import com.fidelity.model.Client;

public interface ClientDao {

	List<Client> getAllClients();
	public void insertClient(Client client);
	public void updateClient(Client client);
	public void deleteClient(String clientId);
	
}
