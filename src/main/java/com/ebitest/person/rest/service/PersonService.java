package com.ebitest.person.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebitest.person.rest.entity.Person;
import com.ebitest.person.rest.repository.dao.BaseDAO;
import com.ebitest.person.rest.repository.dao.PersonDAO;

@Service
public interface PersonService {
	
	//public static final BaseDAO personDao = new PersonDAO();
	
	public List<Person> getPersons();
	public Person find(String id);
	public Person add(Person person);
	public Person update(Person person);
	public Person remove(String id);
}
