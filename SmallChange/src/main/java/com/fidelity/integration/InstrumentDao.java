package com.fidelity.integration;

import java.util.List;

import com.fidelity.model.Instrument;

public interface InstrumentDao {
	
	public abstract List<Instrument> queryAllInstruments();
	
	public abstract Instrument queryInstrumentById(String instrumentId);
	
	public abstract int insertInstrument(Instrument instrument);
	
	public abstract int updateInstrument(Instrument instrument);
	
	public abstract void deleteInstrument(String instrumentId);

}
