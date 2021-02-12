package com.ebitest.person.rest.entity;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

// This POJO entity is created for mapping JSON based on JSONDB in memory database representation
// Annotations used in this POJO is from JSONDB libs
// Annotations must be used from the respective DB template libs for other DBs like Mongo or any other SQL DBs  

@Document(collection = "person", schemaVersion= "1.0")
public class Person {
	
	@Id
	private String first_name;
	private String last_name;
	private int age;
	private String favourite_colour;
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFavourite_colour() {
		return favourite_colour;
	}
	public void setFavourite_colour(String favourite_colour) {
		this.favourite_colour = favourite_colour;
	}	
	
}
