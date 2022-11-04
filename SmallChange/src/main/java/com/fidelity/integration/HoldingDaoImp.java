package com.fidelity.integration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fidelity.model.Holding;
import com.fidelity.model.HoldingReturn;

import oracle.net.aso.m;

@Component
public class HoldingDaoImp implements HoldingDao{
	
	@Autowired
	HoldingMapper holdingMapper;
	

	@Override
	public List<HoldingReturn> getAllHoldings(String clientId) {
		List<Holding> holdings = holdingMapper.getAllHoldings(clientId);
		List<HoldingReturn> holdingReturns = new ArrayList<>();
		for(Holding holding: holdings) {
			holdingReturns.add(new HoldingReturn(holding.getInstrument().getInstrumentId(), holding.getNoOfShares(), holding.getNoOfShares().divide(new BigDecimal(holding.getInstrument().getMaxQuantity())), holding.getDirection(), holding.getPrice(), holding.getNoOfShares().multiply(holding.getPrice()), holding.getGain()));
		}
	
		return holdingReturns;
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
