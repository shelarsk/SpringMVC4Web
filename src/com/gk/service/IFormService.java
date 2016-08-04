package com.gk.service;

import java.util.List;

import com.gk.model.Form;
import com.gk.model.FormField;

public interface IFormService {

	boolean add(Form area) throws Exception;

	List<Form> loadAll() throws Exception;

	boolean update(Form area) throws Exception;

	boolean remove(Form area) throws Exception;

	List<com.google.gson.JsonArray> getJsonAllRecords(Object[] prmObj)
			throws Exception;

	List<Form> loadAllJSON() throws Exception;

	List<FormField> loadFieldAll() throws Exception;

	boolean updateFormField(FormField aObj)throws Exception;

	boolean addFormField(FormField aObj)throws Exception;

	boolean  removeFormField(FormField aObj)throws Exception;

	List<FormField> loadFieldAll(String formID) throws Exception;



}
