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

import com.gk.model.FormField;


/**
 * @author gaurav_kshirsagar
 *
 */
@Repository
public class FormFieldRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "FORM_FIELD";

	public void add(FormField area) throws Exception {
		if (!mongoTemplate.collectionExists(FormField.class)) {
			mongoTemplate.createCollection(FormField.class);
		}
		area.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(area, COLLECTION_NAME);

	}

	public List<FormField> list() {
		return mongoTemplate.findAll(FormField.class, COLLECTION_NAME);
	}
	
	public List<FormField> listBYFormID(String formID) {
		return mongoTemplate.find(new Query(Criteria.where("title")
				.is(formID)),FormField.class, COLLECTION_NAME);
	}

	public void delete(FormField area) {
		System.out.println("deleteing area name => "
				+ area.getId());
		mongoTemplate.remove(new Query(Criteria.where("title")
				.is(area.getId())), COLLECTION_NAME);
		System.out.println("deleteing area.... done");
	}

	public void update(FormField area) {
		mongoTemplate.insert(area, COLLECTION_NAME);
	}
}
