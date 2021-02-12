package com.ebitest.person.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ebitest.person.exceptions.PersonCustomException;
import com.ebitest.person.rest.entity.Person;
import com.ebitest.person.rest.service.PersonService;

@RestController
public class PersonRestController {

	@Autowired
	private Environment env;
	
	@Autowired
    private PersonService service;

    @GetMapping("/person/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person get(@PathVariable String id) {
    	Person response = null;
    	try {
    		if(id != null && !id.isEmpty()) {
    			response = service.find(id);
    		} else {
    			throw new PersonCustomException(env.getProperty("INVALID_INPUT")+" the field name ID");
    		}
    		
    		if(response == null || response.getFirst_name() == null || response.getFirst_name().isEmpty()) {
    			throw new PersonCustomException(env.getProperty("NO_DATA_FOUND"));
    		}
    	} catch(PersonCustomException ce) {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND, ce.getMessage(), ce);
    	} catch(Exception e) {
    		throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Please try after some time", e);
    	}
        return response;
    }
    
    @PostMapping("/person")
    @ResponseStatus(HttpStatus.CREATED)
    public Person post(@RequestBody Person person) {
    	
    	Person response = null;
    	try {
    		response = service.add(person);
    	} catch(Exception e) {
    		throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Please try after some time", e);
    	}
        return response;
    }
    
    @PutMapping("/person")
    @ResponseStatus(HttpStatus.OK)    
    public Person put(@RequestBody Person person) {
    	Person response = null;
    	try {
    		response = service.update(person);
    		if(response == null || response.getFirst_name() == null || response.getFirst_name().isEmpty()) {
    			throw new PersonCustomException(env.getProperty("NO_DATA_FOUND"));
    		}
    	} catch(PersonCustomException ce) {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND, ce.getMessage(), ce);
    	} catch(Exception e) {
    		throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Please try after some time", e);
    	}
    	return response;
    }    
    
    @DeleteMapping("/person/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Person delete(@PathVariable String id) {
    	Person response = null;
		try {
	    	if(id != null && !id.isEmpty()) {
				response = service.remove(id);
			} else {
				throw new PersonCustomException(env.getProperty("INVALID_INPUT")+" the field name ID");
			}
			
			if(response == null || response.getFirst_name() == null || response.getFirst_name().isEmpty()) {
				throw new PersonCustomException(env.getProperty("NO_DATA_FOUND"));
			}
		} catch(PersonCustomException ce) {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND, ce.getMessage(), ce);
    	} catch(Exception e) {
    		throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Please try after some time", e);
    	}
        return response;
    }    
}
