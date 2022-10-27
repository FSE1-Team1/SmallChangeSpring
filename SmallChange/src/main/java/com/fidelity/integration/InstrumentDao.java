package com.fidelity.integration;

import java.util.List;

import com.fidelity.model.Instrument;

public interface InstrumentDao {
	
	public abstract List<Instrument> queryAllInstruments();
	
	public abstract Instrument queryInstrumentById(String instrumentId);
	
	public abstract boolean insertInstrument(Instrument instrument);
	
	public abstract boolean updateInstrument(Instrument instrument);
	
	public abstract boolean deleteInstrument(String instrumentId);

}
