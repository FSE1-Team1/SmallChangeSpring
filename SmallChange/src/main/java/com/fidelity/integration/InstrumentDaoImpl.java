package com.fidelity.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	public int insertInstrument(Instrument instrument) {
		return mapper.insertInstrument(instrument);
	}

	@Override
	public int updateInstrument(Instrument instrument) {
		return mapper.updateInstrument(instrument);
	}

	@Override
	public void deleteInstrument(String instrumentId) {
		mapper.deleteInstrument(instrumentId);
	}

}
