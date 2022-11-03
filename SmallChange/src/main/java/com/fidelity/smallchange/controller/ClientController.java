package com.fidelity.smallchange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerErrorException;

import com.fidelity.model.Client;
import com.fidelity.model.ClientIdentification;
import com.fidelity.restservices.DatabaseRequestResult;
import com.fidelity.service.ClientServiceImpl;

@RestController
public class ClientController {
	
	@Autowired
	private ClientServiceImpl service;
	
//	@Autowired
//	private Logger logger;
	
	private static final String DB_ERROR_MSG = "Error communicating to the SmallChange database";
	
	@GetMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Client>> queryForAllClients() {
		ResponseEntity<List<Client>> result;
		List<Client> clients;
		try {
			clients = service.queryForAllClients();
		} catch(RuntimeException e) {
//			logger.error("Server side error", e);
			throw new ServerErrorException(DB_ERROR_MSG, e);
		}
		if(clients != null && clients.size() > 0) {
			result = ResponseEntity.ok().body(clients);
		} else {
			result = ResponseEntity.noContent().build();
		}
		return result;
	}
	
	@GetMapping(value = "/clients/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> queryForGetClientByEmail(@PathVariable String email) {
		ResponseEntity<Client> result;
		Client client;
		try {
			client = service.queryForGetClientByEmail(email);
		} catch(RuntimeException e) {
//			logger.error("Server side error", e);
			throw new ServerErrorException(DB_ERROR_MSG, e);
		}
		if(client != null) {
			result = ResponseEntity.ok().body(client);
		} else {
			result = ResponseEntity.noContent().build();
		}
		return result;
	}
	
	@PostMapping(value = "/clients", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public DatabaseRequestResult queryForInsertClient(@RequestBody Client client) {
		int rows = 0;
		try {
			rows = service.queryToInsertClient(client);
		} catch (RuntimeException e) {
//			logger.error("Server side error", e);
			throw new ServerErrorException(DB_ERROR_MSG, e);
		}
		if(rows == 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request");
		}
		return new DatabaseRequestResult(rows);
	}
	
	@PostMapping(value = "/clients/client-identification", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public DatabaseRequestResult queryForInsertClientClientIdentification(@RequestBody ClientIdentification identification) {
		int rows = 0;
		try {
			rows = service.queryToInsertClientIdentification(identification);
		} catch (RuntimeException e) {
//			logger.error("Server side error", e);
			throw new ServerErrorException(DB_ERROR_MSG, e);
		}
		if(rows == 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request");
		}
		return new DatabaseRequestResult(rows);
	}
	
	@DeleteMapping(value="/clients/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public DatabaseRequestResult deleteClient(@PathVariable String id) {
		int rows = 0;
		try {
			rows = service.queryToDeleteClient(id);
		} catch (RuntimeException e) {
//			logger.error("Server side error", e);
			throw new ServerErrorException(DB_ERROR_MSG, e);
		}
		if(rows == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No client found in the database with id = " + id);
		}
		return new DatabaseRequestResult(rows);
	}
	
	
}
