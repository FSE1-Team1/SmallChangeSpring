package com.fidelity.restservices;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidelity.integration.ClientDao;
import com.fidelity.model.Client;

@Service
public class ClientService {

	@Autowired
	private ClientDao dao;
	
	public List<Client> queryForAllClients() {
		return dao.getAllClients();
	}
	
	public int queryToInsertClient(Client client) {
		return dao.insertClient(client);
	}
	
	public int queryToDeleteClient(String id) {
		return dao.deleteClient(id);
	}
	
	public int queryToDeleteClientIdentfication(String id) {
		return dao.deleteClientIdentification(id);
	}
	
}
