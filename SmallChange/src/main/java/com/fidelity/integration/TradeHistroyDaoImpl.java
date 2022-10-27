package com.fidelity.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidelity.model.TradeHistory;

@Repository
public class TradeHistroyDaoImpl implements TradeHistoryDao {
	
	@Autowired
	TradeHistoryMapper mapper;
	
	

	public TradeHistroyDaoImpl() {
		
	}

	public List<TradeHistory> getTradeHistory() {
		// TODO Auto-generated method stub
		 return mapper.getTradeHistory();
	}

	public int insertTradeHistory(TradeHistory history) {
		// TODO Auto-generated method stub
		return mapper.insertTradeHistory(history);
	}
	
	
	
}
