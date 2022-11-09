package com.fidelity.smallchange.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.fidelity.model.Client;
import com.fidelity.model.ClientIdentification;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@Sql({"classpath:schema.sql", "classpath:data.sql"})
class ClientControllerE2ETest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	void test_QueryForAllClients_Success() {
		int clientsCount = JdbcTestUtils.countRowsInTable(jdbcTemplate, "sc_client");
		ResponseEntity<Client[]> response = restTemplate.getForEntity("/clients", Client[].class);
		// verify that HTTP status for response is 200 OK
		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
		Client[] clients = response.getBody();
		assertThat(clients.length, is(equalTo(clientsCount)));
	}
	
//	@Test
//	void test_QueryForGetClientByEmail_Success() {
//		String email = "zti@gmail.com";
//		int count = JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "sc_client", "\"email\" = " + email);
//		ResponseEntity<Client[]> response = restTemplate.getForEntity("/clients/"+email, Client[].class);
//		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
//	}

	@Test
	void test_QueryForInsertClient_Succss() {
		Client client = new Client("a", "testname", "lastname", LocalDate.of(2001, 03, 02), "a@gmail.com", "Testing123_", "USA", "101010", new ClientIdentification("a", "SSN", "180180180"));
		ResponseEntity<DatabaseRequestResult> response = restTemplate.postForEntity("/clients", client, DatabaseRequestResult.class);
		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
		int clientsCount = JdbcTestUtils.countRowsInTable(jdbcTemplate, "sc_client");
		assertEquals(2, clientsCount);
	}
	
	@Test
	void test_QueryForDeleteClient_Success() {
		String id = "a";
		Client client = new Client("a", "testname", "lastname", LocalDate.of(2001, 03, 02), "a@gmail.com", "Testing123_", "USA", "101010", new ClientIdentification("a", "SSN", "180180180"));
		ResponseEntity<DatabaseRequestResult> response = restTemplate.postForEntity("/clients", client, DatabaseRequestResult.class);
		restTemplate.delete("/clients/" + id);
		int clientsCount = JdbcTestUtils.countRowsInTable(jdbcTemplate, "sc_client");
		assertEquals(1, clientsCount);
	}

}
