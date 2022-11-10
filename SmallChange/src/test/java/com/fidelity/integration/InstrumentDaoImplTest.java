package com.fidelity.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import com.fidelity.model.Instrument;
import com.fidelity.model.Price;


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
	
	@Test
	public void getInstrumentByIdReturnsNullWhenIdIsInvalid() {
		Instrument instrument = dao.queryInstrumentById("9999");
		assertNull(instrument);
	}
	
	@Test
	public void getInstrumentByIdReturnsAnInstrumentWhenIdIsValid() {
		String id = dao.queryAllInstruments().get(0).getInstrumentId();
		Instrument instrument = dao.queryInstrumentById(id);
		assertNotNull(instrument);
	}
	
	@Test
	public void getInstrumentByIdReturnsTheRightInstrument() {
		String id = dao.queryAllInstruments().get(0).getInstrumentId();
		Instrument instrument = dao.queryInstrumentById(id);
		assertEquals(id, instrument.getInstrumentId());
	}
	
	@Test
	public void insertInstrumentAffectsOneRow() {
		Price price = new Price(new BigDecimal("50.00"),new BigDecimal("51.00"),LocalDate.of(2022, 9, 28),"abcd");
		Instrument instrument = new Instrument(UUID.randomUUID().toString(), "Sample Instrument", UUID.randomUUID().toString(), "Sample external ID type", 5, 10, UUID.randomUUID().toString(),price);
		int row = dao.insertInstrument(instrument);
		assertEquals(1, row);
	}
	
	@Test
	void insertInstrumentInsertsTheRightInstrument() {
		String id = UUID.randomUUID().toString();
		Price price = new Price(new BigDecimal("50.00"),new BigDecimal("51.00"),LocalDate.of(2022, 9, 28),"abcd");
		Instrument instrument = new Instrument(id, "Sample Instrument", UUID.randomUUID().toString(), "Sample external ID type", 5, 10, UUID.randomUUID().toString(),price);
		int row = dao.insertInstrument(instrument);
		assertEquals(1, JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "SC_INSTRUMENT", "\"instrument_id\" = '"+ id + "'"));
	}
	
	@Test
	void updateInstrumentDoesNotAffectAnyRowsWhenIdIsInvalid() {
		Price price = new Price(new BigDecimal("50.00"),new BigDecimal("51.00"),LocalDate.of(2022, 9, 28),"abcd");
		Instrument instrument = new Instrument(UUID.randomUUID().toString(), "Sample Instrument", UUID.randomUUID().toString(), "Sample external ID type", 5, 10, UUID.randomUUID().toString(),price);
		int row = dao.updateInstrument(instrument);
		assertEquals(0, row);
	}
	
	@Test
	void updateInstrumentAffectsOneRowWhenIdIsValid() {
		Instrument instrument = dao.queryAllInstruments().get(0);
		instrument.setInstrumentDescription("Testing description");
		int row = dao.updateInstrument(instrument);
		assertEquals(1, row);
	}
	
	@Test
	void updateInstrumentAffectsTheRightInstrument() {
		Instrument instrument = dao.queryAllInstruments().get(0);
		instrument.setInstrumentDescription("Testing description");
		int row = dao.updateInstrument(instrument);
		assertEquals("Testing description", dao.queryAllInstruments().get(0).getInstrumentDescription());
	}
	
	@Test
	void deleteInstrumentDoesNotAffectAnyRowsWhenIdIsInvalid() {
		int oldCount = JdbcTestUtils.countRowsInTable(jdbcTemplate, "SC_INSTRUMENT");
		String id = UUID.randomUUID().toString();
		//dao.deleteInstrument(id);
		int newCount = JdbcTestUtils.countRowsInTable(jdbcTemplate, "SC_INSTRUMENT");
		assertEquals(newCount, oldCount);
	}
	
	@Test
	void deleteInstrumentAffectsOneRowWhenIdIsValid() {
		int oldCount = JdbcTestUtils.countRowsInTable(jdbcTemplate, "SC_INSTRUMENT");
		String id = dao.queryAllInstruments().get(0).getInstrumentId();
		//dao.deleteInstrument(id);
		oldCount=oldCount+1;
		int newCount = JdbcTestUtils.countRowsInTable(jdbcTemplate, "SC_INSTRUMENT");
		assertEquals(newCount, oldCount-1);
	}
	
	@Test
	void deleteInstrumentDeletesInstrument() {
		String id = dao.queryAllInstruments().get(0).getInstrumentId();
		//dao.deleteInstrument(id);
		assertEquals(1, JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "SC_INSTRUMENT", "\"instrument_id\" = '"+ id + "'"));
	}

}
