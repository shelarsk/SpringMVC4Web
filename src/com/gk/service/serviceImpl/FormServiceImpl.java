package com.gk.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gk.model.Form;
import com.gk.model.FormField;
import com.gk.repository.FormFieldRepository;
import com.gk.repository.FormRepository;
import com.gk.service.IFormService;
import com.google.gson.JsonArray;

@Service
@Transactional(readOnly = true)
public class FormServiceImpl implements IFormService {

	@Autowired
	private FormRepository repository;
	
	@Autowired
	private FormFieldRepository fieldRepository;
	
	

	@Override
	@Transactional(readOnly = false)
	public boolean add(Form area) throws Exception {
		repository.add(area);
		return true;
	}

	@Override
	public List<Form> loadAll() throws Exception {
		return repository.list();
	}

	@Override
	public List<Form> loadAllJSON() throws Exception {
		return repository.list();

	}

	@Override
	@Transactional(readOnly = false)
	public boolean update(Form area) throws Exception {
		repository.update(area);
		return true;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean remove(Form area) throws Exception {
		repository.delete(area);
		return true;
	}

	@Override
	public List<JsonArray> getJsonAllRecords(Object[] prmObj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<FormField> loadFieldAll(String formID) throws Exception {
		return fieldRepository.listBYFormID(formID);
	}

	@Override
	@Transactional(readOnly = false)
	public boolean updateFormField(FormField aObj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean addFormField(FormField aObj) throws Exception {
		// TODO Auto-generated method stub
		fieldRepository.add(aObj);
		return true;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean removeFormField(FormField aObj) throws Exception {
		// TODO Auto-generated method stub
		fieldRepository.delete(aObj);
		return false;
	}

	@Override
	public List<FormField> loadFieldAll() throws Exception {
		return fieldRepository.list();
		
	}

}
