package com.fidelity.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fidelity.integration.InstrumentDao;
import com.fidelity.integration.InstrumentDaoImpl;
import com.fidelity.model.Instrument;
import com.fidelity.restservices.DatabaseRequestResult;

@RestController
@RequestMapping("/instruments")
public class InstrumentService {
	
	@Autowired
	private InstrumentDaoImpl dao;
	
	public InstrumentService() {
		
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Instrument> queryAllInstrumnts() {
		List<Instrument> instruments = null;
		try {
			instruments = dao.queryAllInstruments();
		}
		catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Backend issue",e);
		}
		if(instruments==null || instruments.size()==0) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
		return instruments;
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Instrument queryInstrumentById(@PathVariable String id) {
		Instrument instrument = null;
		if(id=="") {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id cannot be empty");
		}
		try {
			instrument = dao.queryInstrumentById(id);
		}
		catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Backend issue",e);
		}
		if(instrument==null) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
		return instrument;
	}
	
	@PostMapping(value = "/add", consumes = MediaType.ALL_VALUE)
	public DatabaseRequestResult addInstrument(@RequestBody Instrument instrument) {
		int row=0;
		try {
			row = dao.insertInstrument(instrument);
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Backend error",e);
		}
		if (row==0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Provide correct widget");
		}
		return new DatabaseRequestResult(row);
	}
	
	@PutMapping(value = "/modify", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DatabaseRequestResult modifyInstrument(@RequestBody Instrument instrument) {
		int rows=0;
		try {
			rows = dao.updateInstrument(instrument);
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Backend error",e);
		}
		if(rows==0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Provide correct widget");
		}
		return new DatabaseRequestResult(rows);
	}
	
//	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public DatabaseRequestResult removeInstrument(@PathVariable String id) {
//		int rows = 0;
//		try {
//			rows = dao.deleteInstrument(id);
//		} catch (RuntimeException e) {
//			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Backend error",e);
//		}
//		if(rows==0) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Provide correct id");
//		}
//		return new DatabaseRequestResult(rows);
//	}

}
