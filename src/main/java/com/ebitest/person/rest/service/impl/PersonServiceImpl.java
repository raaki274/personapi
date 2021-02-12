package com.ebitest.person.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebitest.person.rest.entity.Person;
import com.ebitest.person.rest.repository.dao.PersonDAO;
import com.ebitest.person.rest.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	
	public PersonServiceImpl() {
		super();
	}

	@Autowired
	private PersonDAO personDao;	
	
	@Override
	public List<Person> getPersons() {

		return null;
	}

	@Override
	public Person find(String id) {
		
		Person personFound = personDao.getPerson(id);
		return personFound;
	}

	@Override
	public Person add(Person person) {
		Person personAdded = personDao.addPerson(person);
		return personAdded;
	}

	@Override
	public Person update(Person person) {

		Person personUpdated = personDao.modifyPerson(person);
		return personUpdated;
	}	

	@Override
	public Person remove(String id) {

		Person personRemoved = personDao.removePerson(id);
		return personRemoved;
	}

}
