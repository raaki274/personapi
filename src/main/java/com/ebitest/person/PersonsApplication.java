package com.ebitest.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.ebitest.person",
		"com.ebitest.person.rest.controller",
		"com.ebitest.person.rest.entity",
		"com.ebitest.person.rest.repository.dao",
		"com.ebitest.person.rest.service",
		"com.ebitest.person.rest.service.impl",
		"com.ebitest.person.utils",
		"com.ebitest.person.exceptions",
		"com.ebitest.person.test.unit",
		"com.ebitest.person.test.integration"})
public class PersonsApplication {
	public static void main(String[] args) {
		SpringApplication.run(PersonsApplication.class, args);
	}
}
