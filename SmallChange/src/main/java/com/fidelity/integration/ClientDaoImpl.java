package com.fidelity.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidelity.model.Client;
import com.fidelity.model.ClientIdentification;

@Repository
public class ClientDaoImpl implements ClientDao {
	
	@Autowired
	ClientMapper mapper;
	
	public ClientDaoImpl() {
		
	}
	
	public List<Client> getAllClients() {
		return mapper.getAllClients();
	}
	
	public int insertClient(Client client) {
		int count = mapper.insertClient(client);
		if(count==1) {
			int count2 = insertClientIdentification(client.getIdentification());
		}
		return count;
	}
	
	public int insertClientIdentification(ClientIdentification identification) {
		return mapper.insertClientIdentification(identification);
	}
	
	public int deleteClientIdentification(String id) {
		return mapper.deleteClientIdentification(id);
	}
	
	public int deleteClient(String id) {
		mapper.deleteClientIdentification(id);
		return mapper.deleteClient(id);
	}

}
