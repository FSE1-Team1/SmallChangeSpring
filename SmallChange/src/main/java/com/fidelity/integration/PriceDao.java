package com.fidelity.integration;

import java.math.BigDecimal;
import java.util.List;

import com.fidelity.model.Price;

public interface PriceDao {
	
	public List<Price> QueryPrice(String instrument_id);
	
	
	public void updateBidPrice(String instrument_id, BigDecimal new_bid_price);
	
	
	public void updateAskPrice(String instrument_id, BigDecimal new_ask_price);
	
	public void insertPrice(Price price);
	
	public void updatePrice(Price price);
	
	public void deletePrice(String instrumentId);
	

}
