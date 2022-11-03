package com.fidelity.integration;

import java.util.List;

import com.fidelity.model.Holding;

public interface HoldingDao {

	List<Holding> getAllHoldings(String clientId);
	int insertHolding(Holding holding);
	int deleteHolding(String clientId, String instrumentId);
	int updateHolding(Holding holding);
}
