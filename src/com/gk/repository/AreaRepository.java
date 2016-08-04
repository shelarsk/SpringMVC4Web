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

import com.gk.model.Area;


/**
 * @author gaurav_kshirsagar
 *
 */
@Repository
public class AreaRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "area";

	public void add(Area area) throws Exception {
		if (!mongoTemplate.collectionExists(Area.class)) {
			mongoTemplate.createCollection(Area.class);
		}
		area.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(area, COLLECTION_NAME);

	}

	public List<Area> list() {
		return mongoTemplate.findAll(Area.class, COLLECTION_NAME);
	}

	public void delete(Area area) {
		System.out.println("deleteing area name => "
				+ area.getName());
		mongoTemplate.remove(new Query(Criteria.where("name")
				.is(area.getName())), COLLECTION_NAME);
		System.out.println("deleteing area.... done");
	}

	public void update(Area area) {
		mongoTemplate.insert(area, COLLECTION_NAME);
	}
}
