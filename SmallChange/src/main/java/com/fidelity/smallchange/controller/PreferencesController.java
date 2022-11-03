package com.fidelity.smallchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fidelity.integration.PreferenceDao;
import com.fidelity.model.Preferences;

@RestController
public class PreferencesController {
	
	@Autowired
	PreferenceDao dao;

	@GetMapping(value = "/preference", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Preferences> getPreference(@RequestHeader("clientId") String id){	
		return ResponseEntity.ok(dao.getPreference(id));
	}
	
	@GetMapping(value = "/insert", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> insertPreference(@RequestHeader Preferences preference){	
		return ResponseEntity.ok(dao.insertPreference(preference));
	}
	
}
