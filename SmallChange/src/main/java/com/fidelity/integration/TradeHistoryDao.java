package com.fidelity.integration;

import java.util.List;

import com.fidelity.model.TradeHistory;

public interface TradeHistoryDao {

	List<TradeHistory> getTradeHistory();
	
	int insertTradeHistory(TradeHistory history);
	
	
	
}
