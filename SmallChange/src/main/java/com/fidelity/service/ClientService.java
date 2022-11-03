package com.fidelity.service;

import java.util.List;

import com.fidelity.model.Client;
import com.fidelity.model.ClientIdentification;


public interface ClientService {

	public List<Client> queryForAllClients();
	public Client queryForGetClientById(String id);
	public int queryToInsertClient(Client client);
	public int queryToInsertClientIdentification(ClientIdentification identification);
	public int queryToDeleteClient(String id);
	public int queryToDeleteClientIdentification(String id);
}
