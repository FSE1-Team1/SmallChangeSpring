package com.fidelity.integration;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fidelity.model.Price;

@Component
public class PriceDaoImpl implements PriceDao {
	
	@Autowired
	PriceMapper priceMapper;
	
//	private DataSource dataSource;
//	
//	private final String queryForGetPriceByInstrumentId = """
//			SELECT * FROM Price WHERE INSTRUMENT_ID=?
//			""";
//	
//	private final String queryForUpdateBidPrice = """
//			UPDATE Price SET bid_price=? WHERE instrument_id=?
//			""";
//	
//	private final String queryForUpdateAskPrice="""
//			UPDATE Price SET ask_price=? WHERE instrument_id=?
//			""";
	
	public PriceDaoImpl() {
//		this.dataSource = dataSource;
		super();
	}

	@Override
	public void updateBidPrice(String instrument_id, BigDecimal new_bid_price) {
		
//		 try (Connection connection = dataSource.getConnection();
//	                PreparedStatement stmt = connection.prepareStatement(this.queryForUpdateBidPrice)) {
//	            stmt.setBigDecimal(1, new_bid_price);
//	            stmt.setString(2, instrument_id);
//	        } catch (SQLException e) {
//	            
//	        }
		this.priceMapper.updateBidPrice(instrument_id, new_bid_price);
		
	}

	@Override
	public void updateAskPrice(String instrument_id, BigDecimal new_ask_price) {
		// TODO Auto-generated method stub
//		try (Connection connection = dataSource.getConnection();
//                PreparedStatement stmt = connection.prepareStatement(this.queryForUpdateAskPrice)) {
//            stmt.setBigDecimal(1, new_ask_price);
//            stmt.setString(2, instrument_id);
//        } catch (SQLException e) {
//            
//        }
		
		this.priceMapper.updateAskPrice(instrument_id, new_ask_price);

	}

	@Override
	public List<Price> QueryPrice(String instrument_id) {
		// TODO Auto-generated method stub
		return this.priceMapper.queryPrice(instrument_id);
	}

}
