package com.fidelity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidelity.integration.TradeHistoryDao;
import com.fidelity.model.TradeHistory;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	TradeHistoryDao dao;
	
	@Override
	public List<TradeHistory> getAllTradeHistory(String id ) {
		return dao.getTradeHistory(id);
		
	}

	@Override
	public int insertTradeHistory(TradeHistory history) {
		// TODO Auto-generated method stub
		return dao.insertTradeHistory(history);
	}

}
