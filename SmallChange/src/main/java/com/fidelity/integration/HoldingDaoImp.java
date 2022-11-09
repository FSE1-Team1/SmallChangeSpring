package com.fidelity.integration;

import java.io.Console;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fidelity.model.Holding;
import com.fidelity.model.HoldingReturn;
import com.fidelity.smallchange.controller.HoldingsController;

import oracle.net.aso.m;

@Component
public class HoldingDaoImp implements HoldingDao{
	
	@Autowired
	HoldingMapper holdingMapper;
	private Logger logger = LoggerFactory.getLogger(HoldingsController.class);
	

	@Override
	public List<HoldingReturn> getAllHoldings(String clientId) {
		List<Holding> holdings = holdingMapper.getAllHoldings(clientId);
		List<HoldingReturn> holdingReturns = new ArrayList<>();
		for(Holding holding: holdings) {
			holdingReturns.add(new HoldingReturn(holding.getInstrument().getInstrumentId(), holding.getNoOfShares(), holding.getNoOfShares().divide(new BigDecimal(holding.getInstrument().getMaxQuantity())), holding.getDirection(), holding.getPrice(), holding.getNoOfShares().multiply(holding.getPrice()), holding.getGain(), holding.getClientId()));
		}
	
		return holdingReturns;
	}

	@Override
	public int insertHolding(HoldingReturn holding) {
		logger.info(holding.getClientId());
		return holdingMapper.insertHolding(holding.getClientId(), holding.getSymbol(), holding.getType(),holding.getShares());
	}

	@Override
	public int deleteHolding(String clientId, String instrumentId) {
		return holdingMapper.deleteHolding(clientId, instrumentId);
	}

	@Override
	public int updateHolding(HoldingReturn holding) {
		List<Holding> holdings = holdingMapper.getAllHoldings(holding.getClientId());
		BigDecimal total= new BigDecimal(0);
		int o=0;
		for(Holding holding1: holdings) {
//			logger.info(holding1.getClientId());
//			logger.info(holding.getClientId());
//			logger.info(holding1.getInstrument().getInstrumentId());
//			logger.info(holding.getSymbol());
			if(holding1.getClientId().contentEquals(holding.getClientId()) && holding1.getInstrument().getInstrumentId().contentEquals(holding.getSymbol())) {
				total = holding1.getNoOfShares();
				o=1;
			}
		}
		if(o==0) {
			//logger.info("aaaaaa");
			return insertHolding(holding);
			
			
		}
		//logger.info("oooo");
		if(holding.getShares().add(total).equals(new BigDecimal(0))) {
			return deleteHolding(holding.getClientId(), holding.getSymbol());
		}
		return holdingMapper.updateHolding(holding.getClientId(), holding.getSymbol(), holding.getType(),holding.getShares().add(total));
	}
	
	

}
