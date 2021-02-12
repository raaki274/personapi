package com.ebitest.person.rest.repository.dao;

import org.springframework.stereotype.Repository;

import com.ebitest.person.rest.entity.Person;
import io.jsondb.JsonDBTemplate;

@Repository
public abstract class BaseDAO {
	
	protected JsonDBTemplate jsonDBTemplate = null;
	public BaseDAO() {
		jsonDBTemplate = new JsonDbConfig().getJsonDBTemplate();	
	}	

	public abstract Person getPerson(String id);
	public abstract Person addPerson(Person person);
	public abstract Person modifyPerson(Person person);
	public abstract Person removePerson(String id);
	
}
