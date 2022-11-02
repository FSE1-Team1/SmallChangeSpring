package com.fidelity.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.fidelity.model.Client;
import com.fidelity.model.ClientIdentification;

@SpringBootTest
@Transactional
class ClientDaoMyBatisImplTest {

	@Autowired
	ClientDaoImpl clientDao;
	
	@Test
	void testDaoNotNull() {
		assertNotNull(clientDao);
	}
	
	@Test
	void testGetAllClients() {
		List<Client> clients = clientDao.getAllClients();
		assertTrue(clients.size() > 0);
	}
	
	@Test
	void testInsertClient() {
		Client client2 = new Client("c7cb85bf-c6df-4d43-a23c-d3b0ddd4743b", "Pavithra", "B", LocalDate.of(2000, 01, 01), "pavithrab@gmail.com", "Testing123*", "IN","18000000", new ClientIdentification("c7cb85bf-c6df-4d43-a23c-d3b0ddd4743b" ,"Passport", "18000000"));
		int count = clientDao.insertClient(client2);
		assertEquals(count,1);
	}
	
	@Test
	void testDeleteClient() {
		String id = "c7cb85bf-c6df-4d43-a23c-d3b0ddd4743b";
		Client client2 = new Client(id, "Pavithra", "B", LocalDate.of(2000, 01, 01), "pavithrab@gmail.com", "Testing123*", "IN","18000000", new ClientIdentification("c7cb85bf-c6df-4d43-a23c-d3b0ddd4743b" ,"Passport", "18000000"));
		int count = clientDao.insertClient(client2);
		assertEquals(count,1);
		int count2 = clientDao.deleteClientIdentification(id);
		assertEquals(count2, 1);
		int count3 = clientDao.deleteClient(id);
		assertEquals(count3, 1);
	}
}
