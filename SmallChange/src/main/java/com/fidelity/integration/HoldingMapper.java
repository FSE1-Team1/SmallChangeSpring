package com.fidelity.integration;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.fidelity.model.Holding;
import com.fidelity.model.Instrument;
import com.fidelity.model.Price;

public interface HoldingMapper {

	@Select("""
			select "client_id" as clientId, "instrument_id" as instrumentId,  "direction" as direction, "no_of_shares" as noOfShares from sc_holding where "client_id"= #{clientId}
			""")
	@Results({
		@Result(property ="clientId", column = "clientId", id = true ),
		@Result(property="instrument", column="instrumentId",one = @One(select = "com.fidelity.integration.InstrumentMapper.queryInstrumentsById")),
		@Result(property ="direction", column = "direction"),
		@Result(property ="noOfShares", column = "noOfShares")
	})
	List<Holding> getAllHoldings(String clientId);
	
	
	
	@Insert("""
			INSERT INTO SC_HOLDING ("client_id", "instrument_id", "direction", "no_of_shares") values (#{clientId},#{instrumentId},#{direction},#{noOfShares})
			""")
	int insertHolding(String clientId, String instrumentId, String direction, BigDecimal noOfShares);
	
	@Delete("""
			delete from sc_holding where "client_id"= #{clientId} and "instrument_id"=#{instrumentId}
			""")
	int deleteHolding(String clientId, String instrumentId);
	
	@Update("""
			update sc_holding SET "client_id"=#{clientId}, "instrument_id"=#{instrumentId}, "direction"=#{direction}, "no_of_shares"=#{noOfShares} where "client_id"= #{clientId} and "instrument_id"=#{instrumentId}
			""")
	int updateHolding(String clientId, String instrumentId, String direction, BigDecimal noOfShares);
}
