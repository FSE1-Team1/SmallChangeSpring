package com.fidelity.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.fidelity.model.Instrument;
import com.fidelity.model.Price;


@SpringBootTest
@Transactional
class PriceDaoImplTest {

	@Autowired
	private PriceDaoImpl dao;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void getPriceandReturnPriceList() {
		List<Price> prices = dao.QueryPrice("T67897");
		assertTrue(prices.size()>0);
	}

}