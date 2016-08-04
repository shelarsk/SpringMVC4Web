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

import com.gk.model.Form;


/**
 * @author gaurav_kshirsagar
 *
 */
@Repository
public class FormRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "FORM";

	public void add(Form area) throws Exception {
		if (!mongoTemplate.collectionExists(Form.class)) {
			mongoTemplate.createCollection(Form.class);
		}
		area.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(area, COLLECTION_NAME);

	}

	public List<Form> list() {
		return mongoTemplate.findAll(Form.class, COLLECTION_NAME);
	}

	public void delete(Form area) {
		System.out.println("deleteing area name => "
				+ area.getTitle());
		mongoTemplate.remove(new Query(Criteria.where("title")
				.is(area.getTitle())), COLLECTION_NAME);
		System.out.println("deleteing area.... done");
	}

	public void update(Form area) {
		mongoTemplate.insert(area, COLLECTION_NAME);
	}
}
