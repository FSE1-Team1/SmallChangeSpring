package com.fidelity.integration;

import java.util.List;

import com.fidelity.model.Client;
import com.fidelity.model.ClientIdentification;

public interface ClientDao {

	public List<Client> getAllClients();
	public int insertClient(Client client);
	public int insertClientIdentification(ClientIdentification identification);
	public int deleteClientIdentification(String id);
//	public void updateClient(Client client);
	public int deleteClient(String id);
	
}
