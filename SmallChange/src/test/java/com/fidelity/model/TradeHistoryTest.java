package com.fidelity.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TradeHistoryTest {
	
	TradeHistory tradeHistory;

	@BeforeEach
	void setUp() throws Exception {
		tradeHistory = new TradeHistory("123ab", BigDecimal.TEN, BigDecimal.ONE, "buy", "1234", "td123", BigDecimal.TEN,LocalDate.now());
	}
	@AfterEach
	void tearDown() throws Exception {
		tradeHistory = null;
	}

	@Test
	void testObjectCreation() {
		
		assertNotNull(tradeHistory);
		
	}
	
	@Test
	void testObjectCreation_passing_null_throws_Exception() {
		assertThrows(IllegalArgumentException.class,()-> {
			new TradeHistory(null, BigDecimal.TEN, BigDecimal.ONE, "1234", "1234", "td123",  BigDecimal.TEN,LocalDate.now());
		});
		}
	
	
	@Test
	void testObjectEquality() {
		TradeHistory tradeHistory1 = new TradeHistory("123ab", BigDecimal.TEN, BigDecimal.ONE, "buy", "1234", "td123",  BigDecimal.TEN,LocalDate.now());
		assertEquals(tradeHistory, tradeHistory1);
		
	}
	@Test
	void testObjectInquality() {
		TradeHistory tradeHistory1 = new TradeHistory("13ab", BigDecimal.TEN, BigDecimal.ONE, "buy", "1234", "td123",  BigDecimal.TEN,LocalDate.now());
		assertNotEquals(tradeHistory, tradeHistory1);
	}
	
	@Test
	void testHashCode() {
		TradeHistory tradeHistory1 = new TradeHistory("123ab", BigDecimal.TEN, BigDecimal.ONE, "buy", "1234", "td123",  BigDecimal.TEN,LocalDate.now());
		assertEquals(tradeHistory.hashCode(), tradeHistory1.hashCode());
	}
	
	@Test
	void testSetInstumentId_nullval_Throws_Exception() {
		assertThrows(IllegalArgumentException.class, () ->{
			tradeHistory.setInstrumentId(null);
		});
		
	}

	@Test
	void testSetClientId_nullval_Throws_Exception() {
		assertThrows(IllegalArgumentException.class, () ->{
			tradeHistory.setClientId(null);
		});
		
	}
	
	@Test
	void testTradeId_nullval_Throws_Exception() {
		assertThrows(IllegalArgumentException.class, () ->{
			tradeHistory.setTradeId(null);
		});
		
	}
	
	@Test
	void testGetInstrumentID() {
		assertEquals("123ab", tradeHistory.getInstrumentId());
	}
	
	@Test
	void testGetClientId() {
		assertEquals("1234", tradeHistory.getClientId());
	}
	
	@Test
	void testGetTradeId() {
		assertEquals("td123", tradeHistory.getTradeId());
	}
	
	@Test
	void testDirection() {
		assertEquals("buy", tradeHistory.getDirection());
	}
	@Test
	void testGetQuantity() {
		assertEquals(BigDecimal.TEN, tradeHistory.getQuantity());
	}
	@Test
	void testGetExecution() {
		assertEquals(BigDecimal.ONE, tradeHistory.getExecutionPrice());
	}
	
	void testGetCashValue() {
		assertEquals(BigDecimal.TEN, tradeHistory.getCashValue());
	}
}
