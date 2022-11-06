package com.fidelity.integration;

import java.util.List;

import com.fidelity.model.Holding;
import com.fidelity.model.HoldingReturn;

public interface HoldingDao {

	List<HoldingReturn> getAllHoldings(String clientId);
	int insertHolding(HoldingReturn holding);
	int deleteHolding(String clientId, String instrumentId);
	int updateHolding(HoldingReturn holding);
}
