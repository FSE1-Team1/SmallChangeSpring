package com.fidelity.integration;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.fidelity.model.Holding;

public interface HoldingMapper {

	@Select("""
			select "no_of_shares" as noOfShares from sc_holding
			""")
	List<Integer> getAllHoldings();
}
