package com.ebitest.person.rest.repository.dao;

import java.util.Map;
import java.util.Properties;

import io.jsondb.JsonDBTemplate;
import io.jsondb.crypto.Default1Cipher;
import io.jsondb.crypto.ICipher;

public class JsonDbConfig {
	
	String dbFilesLocation = "";

	//Java package name where POJO's are present
	String baseScanPackage = "";	
	JsonDBTemplate jsonDBTemplate = null;
	
	public JsonDbConfig() {
		
		//Actual location on disk for database files, process should have read-write permissions to this folder
		String osName = System.getProperties().getProperty("os.name");
		String homeVar = "";
		if(osName.toLowerCase().contains("windows")) {
			homeVar = System.getenv("HOMEPATH");
			dbFilesLocation = "C:"+homeVar+"/jsondb";
		} else {
			homeVar = System.getenv("HOME");
			dbFilesLocation = homeVar+"/jsondb";
		}
	
		//Java package name where POJO's are present
		baseScanPackage = "com.ebitest.person.rest.entity";
	
		//Optionally a Cipher object if you need Encryption
		/*ICipher cipher;
	
		try {
			cipher = new Default1Cipher("1r8+24pibarAWgS85/Heeg==");
		} catch(Exception e) {
			System.out.println(e);
		}
		JsonDBTemplate jsonDBTemplate = new JsonDBTemplate(dbFilesLocation, baseScanPackage, cipher);*/
		
		jsonDBTemplate = new JsonDBTemplate(dbFilesLocation, baseScanPackage);
	}

	public JsonDBTemplate getJsonDBTemplate() {
		return jsonDBTemplate;
	}
}
