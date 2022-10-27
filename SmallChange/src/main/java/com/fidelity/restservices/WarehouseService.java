package com.fidelity.restservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerErrorException;


/**
 * WarehouseService is a RESTful web service.
 * It provides web methods to manage Widgets and Gadgets 
 * in the Warehouse database.
 * 
 * @author ROI Instructor
 *
 */
@RestController
@RequestMapping("/warehouse")
public class WarehouseService {
	private static final String DB_ERROR_MSG = 
			"Error communicating with the warehouse database";
	


	@GetMapping(value="/ping",
				produces=MediaType.ALL_VALUE)
	public String ping() {
		return "Wareshouse web service is alive and awaits your command";
	}
	
	// **** Widget methods ****
	
	
}

