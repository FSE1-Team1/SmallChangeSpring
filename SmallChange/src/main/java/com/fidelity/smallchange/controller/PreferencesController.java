package com.fidelity.smallchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerErrorException;

import com.fidelity.integration.PreferenceDao;
import com.fidelity.model.Preferences;

import ch.qos.logback.classic.Logger;

@RestController
public class PreferencesController {
	
	
	@Autowired
	private PreferenceDao dao;

//	private static final String Error = "Error connecting to the db";
	
	@GetMapping(value = "/preference/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Preferences> getPreference(@PathVariable String id){	
		return ResponseEntity.ok(dao.getPreference(id));
	}
	
	@PostMapping(value = "/insertPreference", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> insertPreference(@RequestBody Preferences preference){	
		return ResponseEntity.ok(dao.insertPreference(preference));
	}
	
	@PutMapping(value = "/updatePreference", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> updatePreference(@RequestBody Preferences preference){
		return ResponseEntity.ok(dao.updatePreference(preference));
		
	}
	
	@DeleteMapping(value ="/preference/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> deletePreference(@PathVariable String id){
		return ResponseEntity.ok(dao.deletePreference(id));
		
	}
	
}
