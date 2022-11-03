package com.fidelity.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fidelity.model.Holding;

import oracle.net.aso.m;

@Component
public class HoldingDaoImp implements HoldingDao{
	
	@Autowired
	HoldingMapper holdingMapper;

	@Override
	public List<Holding> getAllHoldings(String clientId) {
		return holdingMapper.getAllHoldings(clientId);
	}

	@Override
	public int insertHolding(Holding holding) {
		String id= holding.getInstrument().getInstrumentId();
		return holdingMapper.insertHolding(holding.getClientId(), id, holding.getDirection(),holding.getNoOfShares());
	}

	@Override
	public int deleteHolding(String clientId, String instrumentId) {
		return holdingMapper.deleteHolding(clientId, instrumentId);
	}

	@Override
	public int updateHolding(Holding holding) {
		String id= holding.getInstrument().getInstrumentId();
		return holdingMapper.updateHolding(holding.getClientId(), id, holding.getDirection(),holding.getNoOfShares());
	}
	
	

}
