package com.fidelity.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.fidelity.model.TradeHistory;


@Transactional
@SpringBootTest
class TradeHistoryDaoImplTest {

	@Autowired
	TradeHistroyDaoImpl history;
	
	
	
	@Test
	void testObjectCreation() {
		assertNotNull(history);
		
	}
	
	@Test
	void testGetAllTradeHistory() {
		List<TradeHistory> list = history.getTradeHistory();
		assert list.size() > 0;

	}
	
	@Test
	void testInsertTradeHistory() {
		TradeHistory history1  = new TradeHistory("T67897", BigDecimal.TEN, BigDecimal.ONE, "buy",  "ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515","1234", BigDecimal.TEN,LocalDate.now());
		int count = history.insertTradeHistory(history1);
		assertEquals(count,1);
		
		
	}

}
