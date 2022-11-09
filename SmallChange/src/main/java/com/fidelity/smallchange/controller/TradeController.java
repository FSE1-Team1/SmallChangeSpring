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
import org.springframework.web.server.ServerErrorException;

import com.fidelity.model.TradeHistory;
import com.fidelity.service.TradeService;

import oracle.net.nt.AsyncOutboundTimeoutHandler;

@RestController
public class TradeController {

	@Autowired
	TradeService service;
	
	@GetMapping(value = "/history", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TradeHistory>> getAllTradeHistory(@RequestHeader("clientId") String id){
		ResponseEntity<List<TradeHistory>> result;
		List<TradeHistory> list;
		try
		{
			list = service.getAllTradeHistory(id);
		}
		catch(Exception e) {
			throw new ServerErrorException("oops something went wrong ", e);
			
		}
		if(list != null && list.size() > 0)
			result = ResponseEntity.ok(list);
		else
			result = ResponseEntity.noContent().build();
		return result;
		
	}
	
	@PutMapping(value = "/history/insert", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> insertTradeHistory(@RequestBody TradeHistory history){
		System.out.println("inside insert trade history");
		history.setCashValue(history.getExecutionPrice());
		ResponseEntity<Integer> result;
		int count;
			try
			{
				 count = service.insertTradeHistory(history);
			}
			catch(Exception e) {
				System.out.println(e);
				throw new ServerErrorException("oops something went wrong ", e);
				
			}
			
			if(count == 1  )
				result = ResponseEntity.ok(count);
			else
				result = ResponseEntity.noContent().build();
		
		return result;
		
	}
}
