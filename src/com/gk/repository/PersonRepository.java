/**
 * 
 */
package com.gk.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.gk.model.Person;

/**
 * @author gaurav_kshirsagar
 *
 */
@Repository
public class PersonRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "person";
	
	public void addPerson(Person person) throws Exception {
		if (!mongoTemplate.collectionExists(Person.class)) {
			mongoTemplate.createCollection(Person.class);
		}		
		person.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(person, COLLECTION_NAME);
		
	}
	
	public List<Person> listPerson() {
		return mongoTemplate.findAll(Person.class, COLLECTION_NAME);
	}
	
	public void deletePerson(Person person) {
		 System.out.println("deleteing person.... person name => "+person.getName());
		mongoTemplate.remove(new Query(Criteria.where("name").is(person.getName())), COLLECTION_NAME);
		 System.out.println("deleteing person.... done");
	}
	
	public void updatePerson(Person person) {
		mongoTemplate.insert(person, COLLECTION_NAME);		
	}
}
