package com.gk.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.bson.NewBSONDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;







import com.gk.model.Person;
import com.gk.repository.PersonRepository;
import com.gk.service.IPersonService;
import com.gk.vo.sampleVO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	@Transactional(readOnly=false)
	public boolean addPerson(Person person) throws Exception
	{
		 personRepository.addPerson(person);
		 return true;
	}
	
	@Override
		public List<Person> loadAll() throws Exception
	{
		return personRepository.listPerson();
	}
	
	@Override
	@Transactional(readOnly=false)
	public boolean updatePerson(Person person) throws Exception
	{
		personRepository.updatePerson(person);
		return true;
	}
	
	@Override
	@Transactional(readOnly=false)
	public boolean removePerson(Person person) throws Exception
	{
		personRepository.deletePerson(person);
		return true;
	}
	
	@Override
	@Transactional(readOnly=false)
	public List<JsonArray> getJsonAllRecords(Object[] prmObj) throws Exception
	
	{
		List<JsonArray> l= new ArrayList<JsonArray>();
		Gson gson = new Gson();
		JsonArray array= new JsonArray();		
		array.add(gson.toJsonTree(new sampleVO(1,"001", "Gaurav k	", "95520184900","<a href='#'><i class='fa  fa-check-square-o  fa-fw'></i></a>")));
		l.add(array);
		return l;
	}
	
	

}
