package com.fidelity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidelity.integration.ClientDao;
import com.fidelity.model.Client;
import com.fidelity.model.ClientIdentification;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDao dao;
	
	@Override
	public List<Client> queryForAllClients() {
		return dao.getAllClients();
	}
	
	@Override
	public Client queryForGetClientById(String id) {
		return dao.getClientById(id);
	}
	
	@Override
	public int queryToInsertClient(Client client) {
		return dao.insertClient(client);
	}
	
	@Override
	public int queryToInsertClientIdentification(ClientIdentification identification) {
		return dao.insertClientIdentification(identification);
	}
	
	@Override
	public int queryToDeleteClient(String id) {
		return dao.deleteClient(id);
	}
	
	@Override
	public int queryToDeleteClientIdentification(String id) {
		return dao.deleteClientIdentification(id);
	}
	
}
