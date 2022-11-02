package com.fidelity.integration;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.fidelity.model.TradeHistory;

public interface TradeHistoryMapper {

	@Select("""
			SELECT "client_id" as clientId, "cash_value" as cashValue,"instrument_id" as instrumentId,"direction" as direction, "quantity" as quantity,"execution_price" as executionPrice,"trade_id" as tradeId, "trade_timestamp" as tradeTimestamp FROM sc_trade_history
			where "client_id" = #{id}
			""")
	public List<TradeHistory> getTradeHistory(@Param("id") String id);
	
	
	@Insert("""
			INSERT INTO SC_TRADE_HISTORY ("client_id","cash_value","direction","trade_id","instrument_id","quantity","execution_price","trade_timestamp") 
			VALUES(#{clientId}, #{cashValue},#{direction},#{tradeId},#{instrumentId},#{quantity},#{executionPrice},#{tradeTimestamp})
			""")
	public int insertTradeHistory(TradeHistory history);
	

}
