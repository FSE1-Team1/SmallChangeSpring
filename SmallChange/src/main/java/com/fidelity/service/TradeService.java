package com.fidelity.service;

import java.util.List;

import com.fidelity.model.TradeHistory;

public interface TradeService {

	public List<TradeHistory> getAllTradeHistory(String id);

	public int insertTradeHistory(TradeHistory history);
}
