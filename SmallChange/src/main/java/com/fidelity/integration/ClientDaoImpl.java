package com.fidelity.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.fidelity.model.Client;
import com.fidelity.model.ClientIdentification;

@Repository
@Primary
public class ClientDaoImpl implements ClientDao {
	
	@Autowired
	private ClientMapper mapper;
	
	public ClientDaoImpl() {
		
	}
	
	@Override
	public List<Client> getAllClients() {
		return mapper.getAllClients();
	}
	
	@Override
	public Client getClientById(String id) {
		return mapper.getClientById(id);
	}
	
	@Override
	public int insertClient(Client client) {
		int count = mapper.insertClient(client);
		if(count==1) {
			int count2 = insertClientIdentification(client.getIdentification());
		}
		return count;
	}
	
	@Override
	public int insertClientIdentification(ClientIdentification identification) {
		System.out.println(identification.getId());
		System.out.println(identification.getType());
		System.out.println(identification.getValue());
		return mapper.insertClientIdentification(identification);
	}
	
	@Override
	public int deleteClientIdentification(String id) {
		return mapper.deleteClientIdentification(id);
	}
	
	@Override
	public int deleteClient(String id) {
		mapper.deleteClientIdentification(id);
		return mapper.deleteClient(id);
	}

}
