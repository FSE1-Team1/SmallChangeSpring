package com.fidelity.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.fidelity.model.TradeHistory;

@Repository
@Primary
public class TradeHistroyDaoImpl implements TradeHistoryDao {
	
	@Autowired
	TradeHistoryMapper mapper;
	
	public TradeHistroyDaoImpl() {
		
	}

	public List<TradeHistory> getTradeHistory(String id) {
		// TODO Auto-generated method stub
		 return mapper.getTradeHistory(id);
	}

	public int insertTradeHistory(TradeHistory history) {
		// TODO Auto-generated method stub
		return mapper.insertTradeHistory(history);
	}
	
	
	
}
