package com.ebitest.person.rest.repository.dao;

import org.springframework.stereotype.Repository;

import com.ebitest.person.rest.entity.Person;

@Repository
public class PersonDAO extends BaseDAO {
	
	public PersonDAO() {
		super();
	}
	
	@Override
	public Person addPerson(Person person) {
		
		if(jsonDBTemplate.collectionExists(Person.class)) {
			jsonDBTemplate.upsert(person);
		} else {
			jsonDBTemplate.createCollection(Person.class);
			jsonDBTemplate.insert(person);
		}
		return jsonDBTemplate.findById(person.getFirst_name(), Person.class);
	}
	
	@Override
	public Person modifyPerson(Person person) {
		
		Person modifiedPerson = null;
		if(jsonDBTemplate.collectionExists(Person.class)) {
			jsonDBTemplate.save(person, Person.class);
			modifiedPerson = jsonDBTemplate.findById(person.getFirst_name(), Person.class);
		}
		return modifiedPerson;
	}	

	@Override
	public Person removePerson(String id) {
		Person removedPerson = null;
		String jxQuery = String.format("/.[first_name='%s']", id);
		if(jsonDBTemplate.collectionExists(Person.class)) {
			removedPerson = jsonDBTemplate.findById(id, Person.class);			
			jsonDBTemplate.findAllAndRemove(jxQuery, Person.class);
		}
		return removedPerson;
	}

	@Override
	public Person getPerson(String id) {
		return jsonDBTemplate.findById(id, Person.class);
	}


}
