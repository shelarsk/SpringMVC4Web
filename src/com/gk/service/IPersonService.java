package com.gk.service;

import java.util.List;

import com.gk.model.Person;

public interface IPersonService {

	boolean addPerson(Person person) throws Exception;

	List<Person> loadAll() throws Exception;

	boolean updatePerson(Person person) throws Exception;

	boolean removePerson(Person person) throws Exception;

	List<com.google.gson.JsonArray> getJsonAllRecords(Object[] prmObj) throws Exception;

	

}
