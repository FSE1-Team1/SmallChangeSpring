package com.fidelity.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fidelity.model.Holding;

@Component
public class HoldingDaoImp implements HoldingDao{
	
	@Autowired
	HoldingMapper holdingMapper;

	@Override
	public List<Integer> getAllHoldings() {
		return holdingMapper.getAllHoldings();
	}

}
