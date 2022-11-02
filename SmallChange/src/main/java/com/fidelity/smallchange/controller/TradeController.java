package com.fidelity.smallchange.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fidelity.model.TradeHistory;
import com.fidelity.service.TradeService;

@RestController
public class TradeController {

	@Autowired
	TradeService service;
	
	@GetMapping(value = "/history", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TradeHistory>> getAllTradeHistory(@RequestHeader("clientId") String id){

		return ResponseEntity.ok(service.getAllTradeHistory(id));
		
	}
	
	@PutMapping(value = "/insert", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> insertTradeHistory(@RequestBody TradeHistory history){

		return ResponseEntity.ok(service.insertTradeHistory(history));
		
	}
}
