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

import com.fidelity.model.Instrument;
import com.fidelity.model.Price;

public interface PriceMapper {
	
	@Select("""
			SELECT * FROM SC_PRICE WHERE "instrument_id"=#{instrumentId}
			""")
	@Results({
		@Result(property="instrumentId", column="instrument_id", id=true),
		@Result(property="bidPrice", column="bid_price"),
		@Result(property="askPrice", column="ask_price"),
		@Result(property="timeStamp", column="timestamp")
		})
	List<Price> queryPrice(String instrumentId);
	
	@Update("""
			UPDATE SC_PRICE SET "bid_price"=#{newBidPrice} WHERE "instrument_id"=#{instrumentId}
			""")
	void updateBidPrice(String instrumentId, BigDecimal newBidPrice);
	
	@Update("""
			UPDATE SC_PRICE SET "ask_price"=#{newAskPrice} WHERE "instrument_id"=#{instrumentId}
			""")
	void updateAskPrice(String instrumentId, BigDecimal newAskPrice);
	
	@Insert("""
			INSERT INTO SC_PRICE("instrument_id","bid_price","ask_price","timestamp") VALUES (#{instrumentId},#{bidPrice},#{askPrice},#{timeStamp})
			""")
	void insertPrice(Price price);
	
	@Update("""
			UPDATE SC_PRICE SET "bid_price"=#{bidPrice},"ask_price"=#{askPrice},"timestamp"=#{timeStamp} WHERE "instrument_id"=#{instrumentId}
			""")
	void updatePrice(Price price);
	
	@Delete("""
			DELETE FROM SC_PRICE WHERE "instrument_id"=#{instrumentId}
			""")
	void deletePrice(String instrumentId);

}
