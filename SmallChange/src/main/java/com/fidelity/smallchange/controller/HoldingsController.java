package com.fidelity.smallchange.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fidelity.integration.HoldingDaoImp;
import com.fidelity.model.Holding;
import com.fidelity.model.HoldingReturn;

@RestController
@RequestMapping("/holdings")
public class HoldingsController {
	
	//@Autowired
	private Logger logger = LoggerFactory.getLogger(HoldingsController.class);
	
	@Autowired
	private HoldingDaoImp dao;

	
	@GetMapping("/all/{clientId}")
	public ResponseEntity<List<HoldingReturn>> getHoldings(@PathVariable String clientId) {
		List<HoldingReturn> holdings = null;

		try {
			holdings = dao.getAllHoldings(clientId);
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server side error", e);
		}
		
		if (holdings == null) {
			logger.error("Dao returned null");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request");
		}
		
		if(holdings.size()==0) {
			logger.error("Dao returned empty");
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}

		logger.info("Successful retrieval");
		return ResponseEntity.ok(holdings);
	}
	
	@DeleteMapping("/delete/{clientId}/{instrumentId}")
	public ResponseEntity<Integer> deleteHoldings(@PathVariable String clientId,@PathVariable String instrumentId) {
		int rowsAffected = 0;

		try {
			rowsAffected = dao.deleteHolding(clientId, instrumentId);
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server side error", e);
		}
		
		if (rowsAffected == 0) {
			logger.error("Dao returned 0");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request");
		}

		logger.info("Successful deletion");
		return ResponseEntity.ok(rowsAffected);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Integer> updateHoldings(@RequestBody HoldingReturn holding) {
		int rowsAffected = 0;

		try {
			rowsAffected = dao.updateHolding(holding);
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server side error", e);
		}
		
		if (rowsAffected == 0) {
			logger.error("Dao returned 0");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request");
		}

		logger.info("Successful update");
		return ResponseEntity.ok(rowsAffected);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Integer> insertHoldings(@RequestBody HoldingReturn holding) {
		int rowsAffected = 0;

		try {
			rowsAffected = dao.insertHolding(holding);
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server side error", e);
		}
		
		if (rowsAffected == 0) {
			logger.error("Dao returned 0");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request");
		}

		logger.info("Successful insert");
		return ResponseEntity.ok(rowsAffected);
	}
	
}
