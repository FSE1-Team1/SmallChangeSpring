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


@SpringBootTest
@Transactional
class InstrumentDaoImplTest {

	@Autowired
	private InstrumentDaoImpl dao;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void getInstrumentsReturnsAnInstrumentList() {
		List<Instrument> instruments = dao.queryAllInstruments();
		assertTrue(instruments.size()>0);
	}

}
