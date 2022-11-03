package com.fidelity.smallchange.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fidelity.integration.PreferenceDao;
import com.fidelity.integration.PriceDaoImpl;
import com.fidelity.model.Preferences;
import com.fidelity.model.Price;
import com.fidelity.model.TradeHistory;

@RestController
public class PriceController {
	
	@Autowired
	PriceDaoImpl dao;

	@GetMapping(value = "/price", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Price>> getPrice(@RequestHeader("instrumentId") String id){	
		return ResponseEntity.ok(dao.QueryPrice(id));
	}
	
	@PutMapping(value = "/updatebidprice", produces= MediaType.APPLICATION_JSON_VALUE)
	public void updateBidPrice(@RequestBody Price price){	
		dao.updateBidPrice(price.getInstrumentId(), price.getBidPrice());
	}

	
	@PutMapping(value = "/updateaskprice", produces= MediaType.APPLICATION_JSON_VALUE)
	public void updateAskPrice(@RequestBody Price price){	
		dao.updateAskPrice(price.getInstrumentId(), price.getAskPrice());
	}
}
