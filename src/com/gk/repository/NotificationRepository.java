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

import com.gk.model.Notification;


/**
 * @author gaurav_kshirsagar
 *
 */
@Repository
public class NotificationRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "notification";

	public void add(Notification area) throws Exception {
		if (!mongoTemplate.collectionExists(Notification.class)) {
			mongoTemplate.createCollection(Notification.class);
		}
		area.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(area, COLLECTION_NAME);

	}

	public List<Notification> list() {
		return mongoTemplate.findAll(Notification.class, COLLECTION_NAME);
	}

	public void delete(Notification area) {
		System.out.println("deleteing area name => "
				+ area.getTitle());
		mongoTemplate.remove(new Query(Criteria.where("title")
				.is(area.getTitle())), COLLECTION_NAME);
		System.out.println("deleteing area.... done");
	}

	public void update(Notification area) {
		mongoTemplate.insert(area, COLLECTION_NAME);
	}
}
