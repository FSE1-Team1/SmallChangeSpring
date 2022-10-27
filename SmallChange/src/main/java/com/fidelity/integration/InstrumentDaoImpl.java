package com.fidelity.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fidelity.model.Instrument;

@Component
public class InstrumentDaoImpl implements InstrumentDao {
	
	public InstrumentDaoImpl() {
		super();
	}

	@Autowired
	private InstrumentMapper mapper;

	@Override
	public List<Instrument> queryAllInstruments() {
		return mapper.queryAllInstruments();
	}

	@Override
	public Instrument queryInstrumentById(String instrumentId) {
		return mapper.queryInstrumentsById(instrumentId);
	}

	@Override
	public boolean insertInstrument(Instrument instrument) {
		return mapper.insertInstrument(instrument)==1;
	}

	@Override
	public boolean updateInstrument(Instrument instrument) {
		return mapper.updateInstrument(instrument)==1;
	}

	@Override
	public boolean deleteInstrument(String instrumentId) {
		return mapper.deleteInstrument(instrumentId)==1;
	}

}
