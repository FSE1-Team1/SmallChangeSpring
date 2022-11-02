package com.fidelity.integration;

import java.util.List;

import com.fidelity.model.Client;

public interface ClientDao {

	public List<Client> getAllClients();
	public int insertClient(Client client);
	public int deleteClientIdentification(String id);
//	public void updateClient(Client client);
	public int deleteClient(String id);
	
}
